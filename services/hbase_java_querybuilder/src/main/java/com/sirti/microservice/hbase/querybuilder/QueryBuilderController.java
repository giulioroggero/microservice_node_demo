package com.sirti.microservice.hbase.querybuilder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sirti.microservice.hbase.service.HKpiResultSet;
import com.sirti.microservice.hbase.service.HKpiService;

@RestController
public class QueryBuilderController {

	@Autowired
    HKpiService hKpiService;

    @RequestMapping(value = "/kpilist", method = RequestMethod.GET)
  	public HKpiResultSet getAlarms() {
    	return hKpiService.findAll();
  	}
}

