package com.ezen.student.dto;

public class DataBaseConnectionInfo {
	private String jdbcUrl;
	private String driver;
	private String userId;
	private String userPw;
	
	// DB getter/setter
	public String getDriver() {
		return driver;
	}
	
	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getjdbcUrl() {
		return jdbcUrl;
	}

	public void setjdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getuserPw() {
		return userPw;
	}

	public void setuserPw(String userPw) {
		this.userPw = userPw;
	}
}
