



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


/*Estrazione dati dallo storico allarmi con calcolo aggregazioni e kpi per la rappresentazione dei report.
I dati verranno inseriti in HBase nella tabella KPI_FE_UNICO_STORICO' (con column family 'KPI') che ha la seguente struttura:

CREATE TABLE IF NOT EXISTS kpi_fe_unico_storico (
        DATA                DATE not null,
        SILOS               VARCHAR not null,
        POLO                VARCHAR not null,
        ISOLA               VARCHAR not null,
        DOMINIO             VARCHAR not null,
        REGIONE             VARCHAR not null,
        SEVERITY            VARCHAR not null,
        NETWORK             VARCHAR not null,
        FAMIGLIA            VARCHAR not null,
        SLOGAN              VARCHAR not null,
        PIATTAFORMA         VARCHAR not null,
        VENDOR              VARCHAR not null,
        ACK                 INTEGER,
        ACKTT               INTEGER,
        ACKTTP              INTEGER,
        CORR                INTEGER,
        PSISTEMA            INTEGER,
        OUT                 INTEGER,
        NGN                 INTEGER,
        NGNMIN60            INTEGER,
        NGNMAG60            INTEGER,
        PC                  VARCHAR,
        VAI                 INTEGER,
        VAP                 INTEGER,
        VAG                 INTEGER,
        VNTT                INTEGER,
        VCTT                INTEGER,
        DA                  INTEGER,
        IGA                 INTEGER,
        ICRNTT              INTEGER,
        IRRNTT              INTEGER,
        IDNTT               INTEGER,
        IDNTTWR             INTEGER,
        ICONTT              INTEGER,
        ITNTT               INTEGER,
        NTTRSLA             INTEGER,
        NTTDSLA             INTEGER,
        TTRR                INTEGER,
        IRNTTD              INTEGER,
        DTI                 INTEGER

CONSTRAINT PK PRIMARY KEY (DATA,SILOS,POLO,ISOLA,DOMINIO,REGIONE,SEVERITY,
                           NETWORK,FAMIGLIA,SLOGAN,PIATTAFORMA,VENDOR)
);


*/

public class UnicoStorico {
  final static Logger logger = LoggerFactory.getLogger(UnicoStorico.class);

 
  String polo;
  String isola;
  String network;
  String famiglia;
  String piattaforma;
  String vendor;
  String pc;
  
  Integer vai;
  Integer vap;
  Integer vag;
  Integer vntt;
  Integer vctt;

  public UnicoStorico() {}
  public String getPolo() {
    return polo;
  }
  public void setPolo(String polo) {
    this.polo = polo;
  }
  public String getIsola() {
    return isola;
  }
  public void setIsola(String isola) {
    this.isola = isola;
  }
  public String geNetwork() {
    return network;
  }
  public void seNetwork(String network) {
    this.network = network;
  }
  public String getFamiglia() {
    return famiglia;
  }
  public void setFamiglia(String famiglia) {
    this.famiglia = famiglia;
  }
  public String getPiattaforma() {
        return piattaforma;
  }
  public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
  }
  public String getVendor() {
        return vendor;
  }
  public void setVendor(String vendor) {
        this.vendor = vendor;
  }
  public String getPc() {
    return pc;
  }
  public void setPc(String pc) {
    this.pc = pc;
  }
  public Integer getVai() {
    return vai;
  }
  public void setVai(Integer vai) {
    this.vai = vai;
  }
  public Integer getVap() {
    return vap;
  }
  public void setVap(Integer vap) {
    this.vap = vap;
  }
  public Integer getVag() {
    return vag;
  }
  public void setVag(Integer vag) {
    this.vag = vag;
  }
  public Integer getVntt() {
    return vntt;
  }
  public void setVntt(Integer vntt) {
    this.vntt = vntt;
  }
  public Integer getVctt() {
    return vctt;
  }
  public void setVctt(Integer vctt) {
    this.vctt = vctt;
  }
  @Override
  public String toString() {
    return "UnicoStorico{" + "polo=" + polo + ", isola=" + isola + ", network=" + network + ", famiglia=" + famiglia + ", piattaforma=" + piattaforma +  ", vendor=" + vendor + ", pc=" + pc + ", vai=" + vai + ", vap=" + vap + ", vag=" + vag + ", vntt=" + vntt + ", vctt=" + vctt + '}';
  }
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + Objects.hashCode(this.polo);
    hash = 83 * hash + Objects.hashCode(this.isola);
    hash = 83 * hash + Objects.hashCode(this.network);
    hash = 83 * hash + Objects.hashCode(this.famiglia);
    hash = 83 * hash + Objects.hashCode(this.piattaforma);
    hash = 83 * hash + Objects.hashCode(this.vendor);
    hash = 83 * hash + Objects.hashCode(this.pc);
    hash = 83 * hash + Objects.hashCode(this.vai);
    hash = 83 * hash + Objects.hashCode(this.vap);
    hash = 83 * hash + Objects.hashCode(this.vag);
    hash = 83 * hash + Objects.hashCode(this.vntt);
    hash = 83 * hash + Objects.hashCode(this.vctt);
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
    final UnicoStorico other = (UnicoStorico) obj;
    
    if(!Objects.equals(this.polo, other.polo)) {
      return false;
    }   
    if(!Objects.equals(this.isola, other.isola)) {
      return false;
    }
    if(!Objects.equals(this.network, other.network)) {
      return false;
    }
    if(!Objects.equals(this.famiglia, other.famiglia)) {
      return false;
    }
    if(!Objects.equals(this.piattaforma, other.piattaforma)) {
      return false;
    }
    if(!Objects.equals(this.vendor, other.vendor)) {
      return false;
    }
    if(!Objects.equals(this.pc, other.pc)) {
      return false;
    }
    if(!Objects.equals(this.vai, other.vai)) {
      return false;
    }
    if(!Objects.equals(this.vap, other.vap)) {
      return false;
    }
    if(!Objects.equals(this.vag, other.vag)) {
      return false;
    }
    if(!Objects.equals(this.vntt, other.vntt)) {
      return false;
    }
    if(!Objects.equals(this.vctt, other.vctt)) {
      return false;
    }
    return true;
  }
}

