/*jshint expr: true*/
'use strict';

process.env.SERVICE_HOST = 'localhost';
process.env.SERVICE_PORT = 3001;

require('should');
var hw = require('../');

/*jshint camelcase: false */
var dummy = {
    dropdown_list: [{
        label: 'Tipo Report',
        column: 'tipo_report',
        values: [{
            key: 'produzione',
            value: 'Produzione'
        }]
    }, {
        label: 'Silos',
        column: 'silos',
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
        label: 'Polo',
        column: 'polo',
        values: [{
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
        label: 'Famiglia',
        column: 'famiglia',
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
        label: 'Vendor',
        column: 'vendor',
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
        label: 'Piattaforma',
        column: 'piattaforma',
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


describe('Get Catalogue', function() {

  it('It should return all reports', function(done){
    hw.seneca.act({role: 'user', cmd: 'reportcatalogue'}, function(err, res) {
      var expected = dummy;
      res.should.eql(expected);
      done();
    });
  });
});