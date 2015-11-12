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
    //|   SILOS    |   ISOLA    |    POLO    |  REGIONE   | ALLARMI_INSORTI | PRESENTATI | ALLARMI_GESTITI |

    cols.add(new HColumn("Silos","silos"));
    cols.add(new HColumn("Isola","isola"));
    cols.add(new HColumn("Polo","polo"));
    cols.add(new HColumn("Regione","regione"));
    cols.add(new HColumn("Allarmi Insorti","allarmi_insorti"));
    cols.add(new HColumn("Presentati","presentati"));
    cols.add(new HColumn("Allarmi Gestiti","allarmi_gestiti"));
    return cols;
  }

}
