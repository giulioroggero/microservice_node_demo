package com.sirti.microservice.hbase.model;

public class HColumn {

	String label;
	String name;

	public HColumn(String label, String name){
		this.label = label;
		this.name = name;
	}

	public String getLabel(){
		return this.label;
	}

	public String getName(){
		return this.name;
	}


}