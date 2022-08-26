package com.example.storeIp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.storeIp.dao.IpAddressDao;
import com.example.storeIp.model.IpAddress;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/api")
public class IpAddressController {

	@Autowired
	private IpAddressDao ipAddressesDao;
	
	@GetMapping(path = "/ipaddresses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<IpAddress>> getIpAddresses() throws JsonProcessingException {
		final HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		List<IpAddress> ipaddresses= ipAddressesDao.findAll();
        return new ResponseEntity<>(ipaddresses, httpHeaders, HttpStatus.OK);
	}

	@GetMapping(path = "/ipaddress/{ip_address}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getIpAddress(@PathVariable String ip_address) throws JsonProcessingException {
		Optional<IpAddress> ip = ipAddressesDao.findById(ip_address);
		if (!ip.isPresent())
			return new ResponseEntity<>("{\"status\": \"fail\", \"message\": \"ip not found!\"}", HttpStatus.OK);
		return new ResponseEntity<>(new ObjectMapper().writeValueAsString(ip.get()), HttpStatus.OK);
	}

	@PostMapping(path = "/ipaddresses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createIpAddress(@RequestBody IpAddress ip) throws JsonProcessingException {
		System.out.println(ip);
		if (ipAddressesDao.findById(ip.getIpAddress()).isPresent()) {
			return new ResponseEntity<>("{\"status\": \"fail\", \"message\": \"ip existed!\"}", HttpStatus.CONFLICT);
		}

		return new ResponseEntity<>(new ObjectMapper().writeValueAsString(ipAddressesDao.save(ip)), HttpStatus.CREATED);
	}
}
