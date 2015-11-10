/*jshint expr: true*/
'use strict';

require('should');
var hw = require('../');

describe('Connect to HBase', function() {
  
  it('It should connect', function(done){
    hw.seneca.act({role: 'user', cmd: 'query', sql: 'test'}, function(err, res) {
      var expected = { row: '' };
      res.should.eql(expected);
      done();
    });
  });


  

});
