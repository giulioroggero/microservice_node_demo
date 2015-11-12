



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
PROG                 VARCHAR NOT NULL, // Chiave
    kpi.DATA            VARCHAR,  1
    kpi.SILOS           VARCHAR,  2
    kpi.ISOLA           VARCHAR,  3
    kpi.POLO            VARCHAR,  4
    kpi.REGIONE     VARCHAR,    5
    kpi.SEVERITY        VARCHAR,  6
    kpi.DOMINIO     VARCHAR,    7
    kpi.NETWORK     VARCHAR,    8
    kpi.FAMIGLIA        VARCHAR,  9
  kpi.SLOGAN      VARCHAR,    10
    
    kpi.PIATTAFORMA VARCHAR,        11
    kpi.VENDOR      VARCHAR,        12
    kpi.ACK         VARCHAR,        13
    kpi.ACKTT           VARCHAR,    14
    kpi.ACKTTP      VARCHAR,        15
    kpi.CORR            VARCHAR,    16
    kpi.PSISTEMA        VARCHAR,    17
    kpi.OUT         VARCHAR,        18
    kpi.NGN         VARCHAR,        19
    kpi.NGNMIN60        VARCHAR,    20
    kpi.NGMMAG60    VARCHAR,
    kpi.PC              VARCHAR,            // Competenza: giornalieri, settimanali, mensili
    kpi.VAI         VARCHAR,                // Volume allarmi insorti
    kpi.VAP         VARCHAR,                // Volume allarmi presentati
    kpi.VAG         VARCHAR,                // Volume allarmi gestiti
    kpi.VNTT            VARCHAR,            // Volume severity trouble ticket
    kpi.VCTT            VARCHAR,            // Volume customer trouble ticket
    kpi.DA              VARCHAR,            // Densità allarmi
    kpi.IGA         VARCHAR,                // Indice gestione allarmi
    kpi.ICRNTT          VARCHAR,            // Indice di creazione NTT
    kpi.IRRNTT          VARCHAR,            // Indice risoluzione da Remoto NTT
    kpi.IDNTT           VARCHAR,            // Indice dispacciamento NTT
    kpi.IDNTTWR     VARCHAR,                // Indice dispacciamento NTT con Revoca WR
    kpi.ICONTT      VARCHAR,                // Indice correlazione NTT
    kpi.ITNTT           VARCHAR,            // Indice trasferimento NTT
    kpi.NTTRSLA     VARCHAR,                // Num NTT con tempo reazione allarme entro SLA
    kpi.NTTDSLA     VARCHAR,                // Nugetsilosmero NTT con tempo di diagnosi entro SLA
    kpi.TTRR            VARCHAR,            // Ripetitività a 7 giorni su TT RR
    kpi.IRNTTD          VARCHAR,            // Indice di risoluzione di NTT Dispacciati
    kpi.DTI         VARCHAR                 // DTI
CONSTRAINT PK PRIMARY KEY (PROG)
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

  Integer pc;
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
  public Integer getPc() {
    return pc;
  }
  public void setPc(Integer pc) {
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

