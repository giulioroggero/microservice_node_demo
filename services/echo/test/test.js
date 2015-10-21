'use strict';

process.env.SERVICE_HOST = 'localhost';
process.env.SERVICE_PORT = 3002;

var should = require('should');
var hw = require('../');

describe('Echo everythins!', function () {
  it('It should reply Giulio Giulio!', function (done) {
    hw.seneca.act({role: 'user', cmd: 'hello', name: 'Giulio'}, function (err, res) {
      var expected = { message: 'Giulio Giulio!' };
      res.should.eql(expected);
      done();
    });
  });

});
