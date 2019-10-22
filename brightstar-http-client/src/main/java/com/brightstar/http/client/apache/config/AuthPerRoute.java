package com.brightstar.http.client.apache.config;

import org.apache.http.auth.AuthScope;

public class AuthPerRoute {
	
	String host = AuthScope.ANY_HOST;
	int port = AuthScope.ANY_PORT;
	String realm = AuthScope.ANY_REALM;
	String scheme = AuthScope.ANY_SCHEME;
	
	String userName;
	String password;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getRealm() {
		return realm;
	}
	public void setRealm(String realm) {
		this.realm = realm;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	

}
