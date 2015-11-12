package com.sirti.microservice.hbase.querybuilder;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sirti.microservice.hbase.model.SenecaMessage;
import com.sirti.microservice.hbase.model.SenecaMessagePath;
import com.sirti.microservice.hbase.service.HKpiResultSet;
import com.sirti.microservice.hbase.service.HKpiService;
import com.sirti.microservice.hbase.service.RouterRegister;

import com.sirti.microservice.hbase.service.UnicoStoricoResultSet;
import com.sirti.microservice.hbase.service.UnicoStoricoService;

@RestController
public class QueryBuilderController {

	final static Logger logger = LoggerFactory.getLogger(RouterRegister.class);
	
	  @Autowired
    HKpiService hKpiService;

    // FIXME: fare classi generiche------------------------------- (giulio)
    @Autowired
    UnicoStoricoService unicoStoricoService;

    @RequestMapping(value = "/kpilist", method = RequestMethod.GET)
  	public HKpiResultSet getAlarms() {
    	return hKpiService.findAll();
  	}

    @RequestMapping(value = "/unicostorico", method = RequestMethod.GET)
    public UnicoStoricoResultSet getAll() {
      return unicoStoricoService.findAll();
    }
    
    @RequestMapping(value = "/act", method = RequestMethod.POST)
  	public SenecaMessage<HKpiResultSet> getAlarmsFromRouter(@RequestBody SenecaMessagePath message) {
    	
    	logger.info("Router call. role: {}, cmd: {}, message: {}",message.role, message.cmd, message.path);
    	SenecaMessage<HKpiResultSet> ret = new SenecaMessage<HKpiResultSet>();
    	ret.message = hKpiService.findAll();
    	ret.cmd = message.cmd;
    	ret.role = message.role;
    	logger.info("Number of record {}", ret.message.getHKpiList().size());
    	return ret;
  	}
}

