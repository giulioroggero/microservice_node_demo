package com.sirti.microservice.hbase.model;

public class SenecaMessage<T extends SenecaMessageContentBase> {
	public String role = "microservice";
	public String cmd = "register";
	public T message;
	
	public SenecaMessage()
	{
	}
	
}
