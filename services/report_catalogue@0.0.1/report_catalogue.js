'use strict';

// Report Catalogue- Microservice
// 

var debug = require('debug')('ReportCatalogueService');

/*jshint camelcase: false */
var dummy = {
    dropdown_list: [{
        name: 'Tipo Report',
        values: [{
            key: 'produzione',
            value: 'Produzione'
        }]
    }, {
        name: 'Silos',
        values: [{
            key: 'ubb_access',
            value: 'UBB Access'
        }, {
            key: 'all_ip',
            value: 'All Ip & Backbone'
        }, {
            key: 'core',
            value: 'Core, Platforms & Virtual'
        }]
    }, {
        name: 'Polo',
        values: [{
            key: 'roma',
            value: 'Roma'
        }, {
            key: 'milano',
            value: 'Milano'
        }]
    }, {
        name: 'Isola',
        values: [{
            key: 'access_network',
            value: 'Access Network (per UBB Access) '
        }, {
            key: 'backbone_ip',
            value: 'Backbone IP (per All Ip & Backbone)'
        }, {
            key: 'backbone_tx',
            value: 'Backbone TX (per All Ip & Backbone)'
        }, {
            key: 'mobile',
            value: 'Mobile (per Core, Platforms & Virtual Functions)'
        }, {
            key: 'fisso',
            value: 'Fisso (per Core, Platforms & Virtual Functions) '
        }]
    },{
        name: 'Famiglia',
        values: [{
            key: 'adsl',
            value: 'ADSL'
        }, {
            key: 'phd',
            value: 'PHD'
        }, {
            key: 'sdh',
            value: 'SDH'
        }, {
            key: 'ptn',
            value: 'PTN'
        }]
    },{
        name: 'Vendor',
        values: [{
            key: 'alcatel',
            value: 'alcatel'
        }, {
            key: 'ericsson',
            value: 'Ericsson'
        }, {
            key: 'esm',
            value: 'ESM'
        }, {
            key: 'huawei',
            value: 'Huawei'
        }, {
            key: 'italtel',
            value: 'Italtel'
        }, {
            key: 'nokia',
            value: 'Nokia'
        }, {
            key: 'siemens',
            value: 'Siemens'
        }, {
            key: 'teko',
            value: 'TEKO'
        }, {
            key: 'altro',
            value: 'Altro'
        }]
    },{
        name: 'Piattaforma',
        values: [{
            key: 'em',
            value: 'EM'
        }, {
            key: 'gsm',
            value: 'GSM'
        }, {
            key: 'umts',
            value: 'UMTS'
        }, {
            key: 'lte',
            value: 'LTE'
        }, {
            key: 'teko',
            value: 'TEKO'
        }, {
            key: 'wll',
            value: 'WLL'
        }, {
            key: 'gprs',
            value: 'GPRS'
        }, {
            key: 'altro',
            value: 'Altro'
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