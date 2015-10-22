'use strict';

// Hello World - Microservice
// 

var seneca = require('seneca')();
var debug = require('debug')('hello_world');
var HelloService = require('./hello');

// FIXME, usare callback con init per attendere che il servizio abbia completato il setup
var h = new HelloService({seneca: seneca});

h.init(function(err){
	debug(err);
  seneca.listen({host: 'localhost', port: 3001});
  console.log('Hello Microservice listening on ', 'localhost', 3001);
});


// export seneca for mocha
module.exports.seneca = seneca;

