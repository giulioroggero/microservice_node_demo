'use strict';

// Report Catalogue- Microservice
// 
// 

var debug = require('debug')('ReportCatalogueService');

/*
 - label = titolo dropdown
 - column = nome colonna a cui verrà applicato il filtro

 */

/*jshint camelcase: false */
var dummy = {
    dropdown_list: [{
        label: 'Tipo Report',
        column: 'tipo_report',
        values: [{
            key: 'all',
            value: 'All'
        },{
            key: 'produzione',
            value: 'Produzione'
        }]
    }, {
        label: 'Silos',
        column: 'silos',
        values: [{
            key: 'all',
            value: 'All'
        },{
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
        label: 'Polo',
        column: 'polo',
        values: [{
            key: 'all',
            value: 'All'
        },{
            key: 'roma',
            value: 'Roma'
        }, {
            key: 'milano',
            value: 'Milano'
        }]
    }, {
        label: 'Isola',
        column: 'isola',
        values: [{
            key: 'all',
            value: 'All'
        },{
            key: 'Access Network',
            value: 'Access Network (per UBB Access) '
        }, {
            key: 'Backbone IP',
            value: 'Backbone IP (per All Ip & Backbone)'
        }, {
            key: 'Backbone TX',
            value: 'Backbone TX (per All Ip & Backbone)'
        }, {
            key: 'Mobile',
            value: 'Mobile (per Core, Platforms & Virtual Functions)'
        }, {
            key: 'Fisso',
            value: 'Fisso (per Core, Platforms & Virtual Functions) '
        }]
    },{
        label: 'Famiglia',
        column: 'famiglia',
        values: [{
            key: 'all',
            value: 'All'
        },{
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
        label: 'Vendor',
        column: 'vendor',
        values: [{
            key: 'All',
            value: 'All'
        },{
            key: 'Alcatel',
            value: 'Alcatel'
        }, {
            key: 'Ericsson',
            value: 'Ericsson'
        }, {
            key: 'Esm',
            value: 'ESM'
        }, {
            key: 'Huawei',
            value: 'Huawei'
        }, {
            key: 'Italtel',
            value: 'Italtel'
        }, {
            key: 'Nokia',
            value: 'Nokia'
        }, {
            key: 'Siemens',
            value: 'Siemens'
        }, {
            key: 'Teko',
            value: 'TEKO'
        }, {
            key: 'Altri VENDOR',
            value: 'Altro'
        }]
    },{
        label: 'Piattaforma',
        column: 'piattaforma',
        values: [{
            key: 'all',
            value: 'All'
        },{
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