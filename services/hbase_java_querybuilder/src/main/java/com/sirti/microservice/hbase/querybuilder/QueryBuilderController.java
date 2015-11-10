package com.sirti.microservice.hbase.querybuilder;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sirti.microservice.hbase.service.HKpiResultSet;
import com.sirti.microservice.hbase.service.HKpiService;

@RestController
public class QueryBuilderController {

	@Autowired
    HKpiService hKpiService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/kpilist", method = RequestMethod.GET)
  	public HKpiResultSet getAlarms() {
    	return hKpiService.findAll();
  	}
}

