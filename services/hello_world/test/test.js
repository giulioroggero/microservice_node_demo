'use strict';

process.env.SERVICE_HOST = 'localhost';
process.env.SERVICE_PORT = 3001;

var should 	= require('should');
var hw = require('../');

describe('Say hello!', function() {

  it('It should reply Hello Giulio!', function(done){
    hw.seneca.act({role: 'user', cmd: 'echo', name: 'Giulio'}, function(err, res) {
      var expected = { message: 'Hello Giulio!' };
      res.should.eql(expected);
      done();
    });
  });


  it('It should reply Hello Alex!', function(done){
    hw.seneca.act({role: 'user', cmd: 'echo', name: 'Alex'}, function(err, res) {
      var expected = { message: 'Hello Alex!' };
      res.should.eql(expected);
      done();
    });
  });

  it('It should reply Hello Alessandro!', function(done){
    hw.seneca.act({role: 'user', cmd: 'echo', name: 'Alessandro'}, function(err, res) {
      var expected = { message: 'Hello Alessandro!' };
      res.should.eql(expected);
      done();
    });
  });

  it('It should send errror No Name', function(done){
    hw.seneca.act({role: 'user', cmd: 'echo'}, function(err, res) {
      var expected = { message: "No Name" };
      res.should.eql(expected);
      done();
    });
  });

});
