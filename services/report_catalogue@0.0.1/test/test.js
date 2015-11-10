/*jshint expr: true*/
'use strict';

process.env.SERVICE_HOST = 'localhost';
process.env.SERVICE_PORT = 3001;

require('should');
var hw = require('../');

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


describe('Get Catalogue', function() {

  it('It should return all reports', function(done){
    hw.seneca.act({role: 'user', cmd: 'reportcatalogue'}, function(err, res) {
      var expected = dummy;
      res.should.eql(expected);
      done();
    });
  });
});