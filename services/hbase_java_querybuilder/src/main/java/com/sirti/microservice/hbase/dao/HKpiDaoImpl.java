/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirti.microservice.hbase.dao;

import com.sirti.microservice.hbase.model.HKpi;
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

/**
 *
 * @author hadoop
 */
@Repository
public class HKpiDaoImpl
  implements HKpiDao {
  final static Logger logger = LoggerFactory.getLogger(HKpiDaoImpl.class);

  @Value("${querybuilder.hbase.hkpidashboard_table}")
  private String hKpiTable;

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }
  public HKpiDaoImpl() {}
  @PostConstruct
  void postInit() {}
  @PreDestroy
  public void destroy() {}
  @Override
  public int count() {
    return this.jdbcTemplate.queryForObject("select from " + hKpiTable, Integer.class);
  }
  @Override
  public List<HKpi> findAll() {
    String sql = "SELECT TOP(100) FROM "
                 + hKpiTable
    ;
    List<HKpi> alarms = this.jdbcTemplate.query(sql,
                                                new BeanPropertyRowMapper<HKpi>(HKpi.class));
    return alarms;
  }
  @Override
  public void save(HKpi halarm) {
    logger.debug("save invoked, but it's not implemented yet.");
  }
  @Override
  public List<HKpi> findFilterHKpi(String filter) {
    String sql = "SELECT * FROM "
                 + hKpiTable
                 + " WHERE "
                 + filter;
    List<HKpi> alarms = this.jdbcTemplate.query(sql,
                                                new BeanPropertyRowMapper<HKpi>(HKpi.class));
    return alarms;
  }
}
