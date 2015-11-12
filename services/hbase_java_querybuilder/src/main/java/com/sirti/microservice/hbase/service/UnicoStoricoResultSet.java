/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirti.microservice.hbase.service;

import com.sirti.microservice.hbase.model.UnicoStorico;
import com.sirti.microservice.hbase.model.SenecaMessageContentBase;
import com.sirti.microservice.hbase.model.HColumn;
import java.util.List;
import java.util.ArrayList;

//FIXME fare generico!!! (giulio)

/**
 *
 * @author hadoop
 */
public class UnicoStoricoResultSet extends SenecaMessageContentBase {
  Boolean error;
  String errorMsg;
  long duration;
  List<UnicoStorico> unicoStoricoList;

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
  public UnicoStoricoResultSet() {}
  public long getDuration() {
    return duration;
  }
  public void setDuration(long duration) {
    this.duration = duration;
  }
  public List<UnicoStorico> getList() {
    return unicoStoricoList;
  }
  public void setList(List<UnicoStorico> unicoStoricoList) {
    this.unicoStoricoList = unicoStoricoList;
  }

  public List<HColumn> getColumns(){
    List<HColumn> cols = new ArrayList<HColumn>();

    cols.add(new HColumn("Isola","isola"));
    cols.add(new HColumn("Polo","polo"));
    cols.add(new HColumn("Famiglia","famiglia"));
    cols.add(new HColumn("Piattaforma","piattaforma"));
    cols.add(new HColumn("Vendor","vendor"));
    cols.add(new HColumn("PC","pc"));
    cols.add(new HColumn("VAI","vai"));
    cols.add(new HColumn("VAP","vap"));
    cols.add(new HColumn("VAG","vag"));
    cols.add(new HColumn("VNTT","vntt"));
    cols.add(new HColumn("VCTT","vctt"));

    return cols;
  }

}
