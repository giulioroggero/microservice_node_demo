/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirti.microservice.hbase.dao;

import com.sirti.microservice.hbase.model.HKpi;
import java.util.List;

/**
 *
 * @author hadoop
 */
public interface HKpiDao {
  public void save(HKpi halarm);
  public int count();
  public List<HKpi> findAll();
  public List<HKpi> findFilterHKpi(String filter);
}
