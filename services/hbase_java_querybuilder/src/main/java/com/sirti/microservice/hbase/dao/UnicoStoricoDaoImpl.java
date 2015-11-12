/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirti.microservice.hbase.dao;

import com.sirti.microservice.hbase.model.UnicoStorico;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//FIXME fare generico!!! (giulio)


/**
 *
 * @author hadoop
 */
@Repository
public class UnicoStoricoDaoImpl
  implements UnicoStoricoDao {
  final static Logger logger = LoggerFactory.getLogger(UnicoStoricoDaoImpl.class);

  @Value("${querybuilder.hbase.KPI_FE_UNICO_STORICO}")
  private String hKpiTable;

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }
  public UnicoStoricoDaoImpl() {}
  @PostConstruct
  void postInit() {}
  @PreDestroy
  public void destroy() {}
  @Override
  public int count() {
    return this.jdbcTemplate.queryForObject("select from " + hKpiTable, Integer.class);
  }
  @Override
  public List<UnicoStorico> findAll() {
    String sql = "SELECT * FROM "
                 + hKpiTable
    ;
    List<UnicoStorico> alarms = this.jdbcTemplate.query(sql,
                                                new BeanPropertyRowMapper<UnicoStorico>(UnicoStorico.class));
    return alarms;
  }
  @Override
  public void save(UnicoStorico halarm) {
    logger.debug("save invoked, but it's not implemented yet.");
  }
  @Override
  public List<UnicoStorico> findFilterUnicoStorico(String filter) {
    String sql = "SELECT * FROM "
                 + hKpiTable
                 + " WHERE "
                 + filter;
    List<UnicoStorico> alarms = this.jdbcTemplate.query(sql,
                                                new BeanPropertyRowMapper<UnicoStorico>(UnicoStorico.class));
    return alarms;
  }
}
