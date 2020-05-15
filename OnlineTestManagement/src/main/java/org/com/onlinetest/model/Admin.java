package org.com.onlinetest.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger adminId;
	private String adminName;
	private String adminPassword;
	public BigInteger getAdminId() {
		return adminId;
	}
	public void setAdminId(BigInteger adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
	
	
	
	
}

