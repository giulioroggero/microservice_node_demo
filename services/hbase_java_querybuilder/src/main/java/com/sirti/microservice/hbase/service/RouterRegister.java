package com.sirti.microservice.hbase.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sirti.microservice.hbase.model.SenecaMessage;
import com.sirti.microservice.hbase.model.SenecaMessageRegister;

@Component
public class RouterRegister implements ApplicationListener<ContextRefreshedEvent> {

	final static Logger logger = LoggerFactory.getLogger(RouterRegister.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		RestTemplate restTemplate = new RestTemplate();
		
		SenecaMessage<SenecaMessageRegister> request = new SenecaMessage<SenecaMessageRegister>();
		request.message = new SenecaMessageRegister();
		request.message.clientPort = "9999";
		request.message.cmd = "kpilist";
		request.message.role = "user";
		
		
        String result ="";
		try {
			result = restTemplate.postForObject("http://localhost:2999/act", request,String.class);
			logger.info(result);
		} catch (RestClientException e) {
			logger.error(e.getMessage());
		}
        
        
	}
}
