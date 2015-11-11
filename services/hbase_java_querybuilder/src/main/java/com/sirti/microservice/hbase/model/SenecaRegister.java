package com.sirti.microservice.hbase.model;

public class SenecaRegister {
	public String role = "microservice";
	public String cmd = "register";
	public SenecaRegisterMessage message;
	
	public SenecaRegister()
	{
		message = new SenecaRegisterMessage();
	}
	
}
