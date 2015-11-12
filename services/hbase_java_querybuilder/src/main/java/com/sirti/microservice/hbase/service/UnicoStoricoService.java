/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirti.microservice.hbase.service;

import com.sirti.microservice.hbase.dao.UnicoStoricoDao;
import com.sirti.microservice.hbase.model.UnicoStorico;
import com.sirti.microservice.hbase.service.UnicoStoricoService;
import com.sirti.microservice.hbase.service.UnicoStoricoResultSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//FIXME fare generico!!! (giulio)

/**
 *
 * @author hadoop
 */
@Service
public class UnicoStoricoService {
  @Autowired
  UnicoStoricoDao unicoStoricoDao;

  public UnicoStoricoResultSet findAll() {
    UnicoStoricoResultSet hkpiresultset
      = new UnicoStoricoResultSet();

    try {
      long starttime = System.nanoTime();
      List<UnicoStorico> hkpilist
        = unicoStoricoDao.findAll();
      long endtime = System.nanoTime();
      hkpiresultset.setList(hkpilist);
      hkpiresultset.setDuration((endtime - starttime) / 1000000);
      hkpiresultset.setError(Boolean.FALSE);
    } catch(Exception e) {
      hkpiresultset.setError(Boolean.TRUE);
      hkpiresultset.setErrorMsg(e.getLocalizedMessage());
    }
    return hkpiresultset;
  }
  public UnicoStoricoResultSet findFilterAlarms(String filter) {
    UnicoStoricoResultSet hkpiresultset
      = new UnicoStoricoResultSet();

    try {
      long starttime = System.nanoTime();
      List<UnicoStorico> hkpilist
        = unicoStoricoDao.findFilterUnicoStorico(filter);
      long endtime = System.nanoTime();
      hkpiresultset.setList(hkpilist);
      hkpiresultset.setDuration((endtime - starttime) / 1000000);
      hkpiresultset.setError(Boolean.FALSE);
    } catch(Exception e) {
      hkpiresultset.setError(Boolean.TRUE);
      hkpiresultset.setErrorMsg(e.getLocalizedMessage());
    }
    return hkpiresultset;
  }
}
