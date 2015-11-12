/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirti.microservice.hbase.service;

import com.sirti.microservice.hbase.model.HKpi;
import com.sirti.microservice.hbase.model.SenecaMessageContentBase;

import java.util.List;

/**
 *
 * @author hadoop
 */
public class HKpiResultSet extends SenecaMessageContentBase {
  Boolean error;
  String errorMsg;
  long duration;
  List<HKpi> hKpiList;

  public Boolean getError() {
    return error;
  }
  public void setError(Boolean error) {
    this.error = error;
  }
  public String getErrorMsg() {
    return errorMsg;
  }
  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }
  public HKpiResultSet() {}
  public long getDuration() {
    return duration;
  }
  public void setDuration(long duration) {
    this.duration = duration;
  }
  public List<HKpi> getHKpiList() {
    return hKpiList;
  }
  public void setHKpiList(List<HKpi> hKpiList) {
    this.hKpiList = hKpiList;
  }
}
