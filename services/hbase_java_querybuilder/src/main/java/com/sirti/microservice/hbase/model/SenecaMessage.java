package com.sirti.microservice.hbase.model;

public class SenecaMessage<T extends SenecaMessageContentBase> {
	

	public String role;
	public String cmd;
	public T message;
	
	public SenecaMessage()
	{
	}
	
}
