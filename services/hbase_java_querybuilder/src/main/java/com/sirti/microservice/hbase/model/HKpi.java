/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirti.microservice.hbase.model;

import java.sql.Date;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hadoop
 */

// CREATE TABLE IF NOT EXISTS h_kpi_dashboard (
//
// DATA                    DATE not null,
// REGIONE                 VARCHAR NOT NULL,
// SEVERITY                VARCHAR NOT NULL,
// DOMINIO                 VARCHAR NOT NULL,
// SLOGAN                  VARCHAR NOT NULL,
// NETWORK                 VARCHAR NOT NULL,
// SUBNETWORK              VARCHAR NOT NULL,
// MGMTCENTER              VARCHAR NOT NULL,
// COSTRUTTORE             VARCHAR NOT NULL,
// ACK                     INTEGER,
// ACK_TT                  INTEGER,
// ACK_PARK                INTEGER,
// CORRELATO               INTEGER,
// PARKSISTEMA             INTEGER,
// OUTAGE                  INTEGER,
// NON_GESTITI_NOTE        INTEGER,
// NON_GESTITI_MIN_60      INTEGER,
// NON_GESTITI_MAG_60      INTEGER,
// TOTALE_CONTATORI        INTEGER
//
// CONSTRAINT PK PRIMARY KEY (DATA,REGIONE,SEVERITY,DOMINIO,SLOGAN,NETWORK,SUBNETWORK,MGMTCENTER,COSTRUTTORE)
// );

public class HKpi {
  final static Logger logger = LoggerFactory.getLogger(HKpi.class);

  Date data;
  String regione;
  String severity;
  String dominio;
  String slogan;
  String network;
  String subnetwork;
  String mgmtcenter;
  String costruttore;
  Integer ack;
  Integer ack_tt;
  Integer ack_park;
  Integer correlato;
  Integer parksistema;
  Integer outage;
  Integer non_gestiti_note;
  Integer non_gestiti_min_60;
  Integer non_gestiti_mag_60;
  Integer totale_contatori;

  public HKpi() {}
  public Date getData() {
    return data;
  }
  public void setData(Date data) {
    this.data = data;
  }
  public String getRegione() {
    return regione;
  }
  public void setRegione(String regione) {
    this.regione = regione;
  }
  public String getSeverity() {
    return severity;
  }
  public void setSeverity(String severity) {
    this.severity = severity;
  }
  public String getDominio() {
    return dominio;
  }
  public void setDominio(String dominio) {
    this.dominio = dominio;
  }
  public String getSlogan() {
    return slogan;
  }
  public void setSlogan(String slogan) {
    this.slogan = slogan;
  }
  public String getNetwork() {
    return network;
  }
  public void setNetwork(String network) {
    this.network = network;
  }
  public String getSubnetwork() {
    return subnetwork;
  }
  public void setSubnetwork(String subnetwork) {
    this.subnetwork = subnetwork;
  }
  public String getMgmtcenter() {
    return mgmtcenter;
  }
  public void setMgmtcenter(String mgmtcenter) {
    this.mgmtcenter = mgmtcenter;
  }
  public String getCostruttore() {
    return costruttore;
  }
  public void setCostruttore(String costruttore) {
    this.costruttore = costruttore;
  }
  public Integer getAck() {
    return ack;
  }
  public void setAck(Integer ack) {
    this.ack = ack;
  }
  public Integer getAck_tt() {
    return ack_tt;
  }
  public void setAck_tt(Integer ack_tt) {
    this.ack_tt = ack_tt;
  }
  public Integer getAck_park() {
    return ack_park;
  }
  public void setAck_park(Integer ack_park) {
    this.ack_park = ack_park;
  }
  public Integer getCorrelato() {
    return correlato;
  }
  public void setCorrelato(Integer correlato) {
    this.correlato = correlato;
  }
  public Integer getParksistema() {
    return parksistema;
  }
  public void setParksistema(Integer parksistema) {
    this.parksistema = parksistema;
  }
  public Integer getOutage() {
    return outage;
  }
  public void setOutage(Integer outage) {
    this.outage = outage;
  }
  public Integer getNon_gestiti_note() {
    return non_gestiti_note;
  }
  public void setNon_gestiti_note(Integer non_gestiti_note) {
    this.non_gestiti_note = non_gestiti_note;
  }
  public Integer getNon_gestiti_min_60() {
    return non_gestiti_min_60;
  }
  public void setNon_gestiti_min_60(Integer non_gestiti_min_60) {
    this.non_gestiti_min_60 = non_gestiti_min_60;
  }
  public Integer getNon_gestiti_mag_60() {
    return non_gestiti_mag_60;
  }
  public void setNon_gestiti_mag_60(Integer non_gestiti_mag_60) {
    this.non_gestiti_mag_60 = non_gestiti_mag_60;
  }
  public Integer getTotale_contatori() {
    return totale_contatori;
  }
  public void setTotale_contatori(Integer totale_contatori) {
    this.totale_contatori = totale_contatori;
  }
  @Override
  public String toString() {
    return "HKpi{" + "data=" + data + ", regione=" + regione + ", severity=" + severity + ", dominio=" + dominio + ", slogan=" + slogan + ", network=" + network + ", subnetwork=" + subnetwork + ", mgmtcenter=" + mgmtcenter + ", costruttore=" + costruttore + ", ack=" + ack + ", ack_tt=" + ack_tt + ", ack_park=" + ack_park + ", correlato=" + correlato + ", parksistema=" + parksistema + ", outage=" + outage + ", non_gestiti_note=" + non_gestiti_note + ", non_gestiti_min_60=" + non_gestiti_min_60 + ", non_gestiti_mag_60=" + non_gestiti_mag_60 + ", totale_contatori=" + totale_contatori + '}';
  }
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.data);
    hash = 83 * hash + Objects.hashCode(this.regione);
    hash = 83 * hash + Objects.hashCode(this.severity);
    hash = 83 * hash + Objects.hashCode(this.dominio);
    hash = 83 * hash + Objects.hashCode(this.slogan);
    hash = 83 * hash + Objects.hashCode(this.network);
    hash = 83 * hash + Objects.hashCode(this.subnetwork);
    hash = 83 * hash + Objects.hashCode(this.mgmtcenter);
    hash = 83 * hash + Objects.hashCode(this.costruttore);
    hash = 83 * hash + Objects.hashCode(this.ack);
    hash = 83 * hash + Objects.hashCode(this.ack_tt);
    hash = 83 * hash + Objects.hashCode(this.ack_park);
    hash = 83 * hash + Objects.hashCode(this.correlato);
    hash = 83 * hash + Objects.hashCode(this.parksistema);
    hash = 83 * hash + Objects.hashCode(this.outage);
    hash = 83 * hash + Objects.hashCode(this.non_gestiti_note);
    hash = 83 * hash + Objects.hashCode(this.non_gestiti_min_60);
    hash = 83 * hash + Objects.hashCode(this.non_gestiti_mag_60);
    hash = 83 * hash + Objects.hashCode(this.totale_contatori);
    return hash;
  }
  @Override
  public boolean equals(Object obj) {
    if(obj == null) {
      return false;
    }
    if(getClass() != obj.getClass()) {
      return false;
    }
    final HKpi other = (HKpi) obj;
    if(!Objects.equals(this.data, other.data)) {
      return false;
    }
    if(!Objects.equals(this.regione, other.regione)) {
      return false;
    }
    if(!Objects.equals(this.severity, other.severity)) {
      return false;
    }
    if(!Objects.equals(this.dominio, other.dominio)) {
      return false;
    }
    if(!Objects.equals(this.slogan, other.slogan)) {
      return false;
    }
    if(!Objects.equals(this.network, other.network)) {
      return false;
    }
    if(!Objects.equals(this.subnetwork, other.subnetwork)) {
      return false;
    }
    if(!Objects.equals(this.mgmtcenter, other.mgmtcenter)) {
      return false;
    }
    if(!Objects.equals(this.costruttore, other.costruttore)) {
      return false;
    }
    if(!Objects.equals(this.ack, other.ack)) {
      return false;
    }
    if(!Objects.equals(this.ack_tt, other.ack_tt)) {
      return false;
    }
    if(!Objects.equals(this.ack_park, other.ack_park)) {
      return false;
    }
    if(!Objects.equals(this.correlato, other.correlato)) {
      return false;
    }
    if(!Objects.equals(this.parksistema, other.parksistema)) {
      return false;
    }
    if(!Objects.equals(this.outage, other.outage)) {
      return false;
    }
    if(!Objects.equals(this.non_gestiti_note, other.non_gestiti_note)) {
      return false;
    }
    if(!Objects.equals(this.non_gestiti_min_60, other.non_gestiti_min_60)) {
      return false;
    }
    if(!Objects.equals(this.non_gestiti_mag_60, other.non_gestiti_mag_60)) {
      return false;
    }
    if(!Objects.equals(this.totale_contatori, other.totale_contatori)) {
      return false;
    }
    return true;
  }
}
