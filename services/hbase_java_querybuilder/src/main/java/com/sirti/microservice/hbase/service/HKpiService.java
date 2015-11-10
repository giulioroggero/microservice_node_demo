/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirti.microservice.hbase.service;

import com.sirti.microservice.hbase.dao.HKpiDao;
import com.sirti.microservice.hbase.model.HKpi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hadoop
 */
@Service
public class HKpiService {
  @Autowired
  HKpiDao hKpiDao;

  public HKpiResultSet findAll() {
    HKpiResultSet hkpiresultset
      = new HKpiResultSet();

    try {
      long starttime = System.nanoTime();
      List<HKpi> hkpilist
        = hKpiDao.findAll();
      long endtime = System.nanoTime();
      hkpiresultset.setHKpiList(hkpilist);
      hkpiresultset.setDuration((endtime - starttime) / 1000000);
      hkpiresultset.setError(Boolean.FALSE);
    } catch(Exception e) {
      hkpiresultset.setError(Boolean.TRUE);
      hkpiresultset.setErrorMsg(e.getLocalizedMessage());
    }
    return hkpiresultset;
  }
  public HKpiResultSet findFilterAlarms(String filter) {
    HKpiResultSet hkpiresultset
      = new HKpiResultSet();

    try {
      long starttime = System.nanoTime();
      List<HKpi> hkpilist
        = hKpiDao.findFilterHKpi(filter);
      long endtime = System.nanoTime();
      hkpiresultset.setHKpiList(hkpilist);
      hkpiresultset.setDuration((endtime - starttime) / 1000000);
      hkpiresultset.setError(Boolean.FALSE);
    } catch(Exception e) {
      hkpiresultset.setError(Boolean.TRUE);
      hkpiresultset.setErrorMsg(e.getLocalizedMessage());
    }
    return hkpiresultset;
  }
}
