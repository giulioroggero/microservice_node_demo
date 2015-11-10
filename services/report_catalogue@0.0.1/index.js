'use strict';

// Hello World - Microservice
// 

var seneca = require('seneca')();
var debug = require('debug')('report_catalogue');
var ReportCatalogueService = require('./report_catalogue');

// FIXME, usare callback con init per attendere che il servizio abbia completato il setup
var c = new ReportCatalogueService({seneca: seneca});

c.init(function(err){
	debug(err);
  seneca.listen({host: 'localhost', port: 3010});
  console.log('Report Catalogue Service listening on ', 'localhost', 3010);
});


// export seneca for mocha
module.exports.seneca = seneca;
