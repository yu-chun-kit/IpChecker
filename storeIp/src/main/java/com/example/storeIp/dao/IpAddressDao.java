package com.example.storeIp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeIp.model.IpAddress;

public interface IpAddressDao extends JpaRepository<IpAddress, String> {
}
