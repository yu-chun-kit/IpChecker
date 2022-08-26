package com.example.storeIp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IP_ADDRESS")
public class IpAddress implements Serializable {

	@Id
	@Column(name = "ip_address")
	private String ipAddress;

	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;

	@Column(name = "regionName")
	private String regionName;

	@Column(name = "zip")
	private String zip;

	@Column(name = "timezone")
	private String timezone;

	@Column(name = "isp")
	private String isp;

	@Column(name = "org")
	private String org;

	@Column(name = "lat")
	private int lat;

	@Column(name = "lon")
	private int lon;

	public IpAddress() {

	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public int getLat() {
		return lat;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	public int getLon() {
		return lon;
	}

	public void setLon(int lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "IpAddress [ipAddress=" + ipAddress + ", country=" + country + ", city=" + city + ", regionName="
				+ regionName + ", zip=" + zip + ", timezone=" + timezone + ", isp=" + isp + ", org=" + org + ", lat="
				+ lat + ", lon=" + lon + "]";
	}

}
