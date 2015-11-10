'use strict';

// Report Catalogue- Microservice
// 

var debug = require('debug')('ReportCatalogueService');

/*jshint camelcase: false */
var dummy = {
    dropdown_list: [{
        name: 'dropdown1',
        values: [{
            key: 'chiave1',
            value: 'valore1'
        }, {
            key: 'chiave2',
            value: 'valore3'
        }]
    }, {
        name: 'dropdown2',
        values: [{
            key: 'chiave1',
            value: 'valore1'
        }, {
            key: 'chiave2',
            value: 'valore3'
        }]
    }]
};

function ReportCatalogueService(options){
  this.seneca = options.seneca;
}

ReportCatalogueService.prototype.init = function (cb){
  var self = this;
  debug('Init service');

  self.seneca.add({role: 'user', cmd: 'reportcatalogue'}, function (msg, respond) {
    if (respond){
      	respond(null, dummy);
    }
  });

  self.registerService(cb);

};

ReportCatalogueService.prototype.registerService = function(cb){
  this.seneca.client({ port:2999, pin: {role:'microservice',cmd:'register'} });
  this.seneca.act({role:'microservice',cmd:'register', message:  { clientPort: 3010, role: 'user', cmd: 'reportcatalogue'} }, cb);
};


module.exports = ReportCatalogueService;