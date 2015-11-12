/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirti.microservice.hbase.dao;

import com.sirti.microservice.hbase.model.UnicoStorico;
import java.util.List;

//FIXME fare generico!!! (giulio)

/**
 *
 * @author hadoop
 */
public interface UnicoStoricoDao {
  public void save(UnicoStorico halarm);
  public int count();
  public List<UnicoStorico> findAll();
  public List<UnicoStorico> findFilterUnicoStorico(String filter);
}
