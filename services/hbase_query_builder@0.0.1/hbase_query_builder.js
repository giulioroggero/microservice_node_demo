'use strict';

// HBase Query Builder - Microservice
// 

var debug = require('debug')('HBaseQueryBuilder');
var HBase = require('hbase-client');

function HBaseQueryBuilder(options){
  this.seneca = options.seneca;
  this.client = {};
  this.client = HBase.create({
    zookeeperHosts: ['c6401.ambari.apache.org:2181'], // only local zookeeper],
    zookeeperRoot: '/hbase-unsecure'
  });
}

HBaseQueryBuilder.prototype.init = function (cb){
  var self = this;
  debug('Init service');

  self.seneca.add({role: 'user', cmd: 'query'}, function (query, respond) {
    debug('respond', respond);
    if (respond){
      debug('query', query);
      if (query.sql){
        var param = new HBase.Get('foo');
        param.addColumn('f1', 'REGIONE');
        param.addColumn('f1', 'SEVERITY');
        self.client.get('h_kpi_dashboard', param, function (err, result) {
          debug('result', result);
          respond(null, {result: result});
        });
      	
      }else{
      	// FIXME, use error code convention ...
      	respond(null, {message: 'No Name'});
     }
    }
  });

  self.registerService(cb);

};

HBaseQueryBuilder.prototype.registerService = function(cb){
	cb(null);
};

module.exports = HBaseQueryBuilder;