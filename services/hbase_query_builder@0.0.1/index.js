'use strict';

// HBase Query Builder - Microservice
// 

var seneca = require('seneca')();
var debug = require('debug')('hbase_query_builder');
var HBaseQueryBuilder = require('./hbase_query_builder');

// FIXME, usare callback con init per attendere che il servizio abbia completato il setup
var qb = new HBaseQueryBuilder({seneca: seneca});

qb.init(function(err){
	debug(err);
  seneca.listen({host: 'localhost', port: 3050});
  console.log('Hbase Query Builder listening on ', 'localhost', 3050);
});


// export seneca for mocha
module.exports.seneca = seneca;
