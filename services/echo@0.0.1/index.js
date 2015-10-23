'use strict';

// Echo - Microservice

var seneca = require('seneca')();
var debug = require('debug')('EchoService');
var EchoService = require('./echo');

// FIXME, usare callback con init per attendere che il servizio abbia completato il setup
var h = new EchoService({seneca: seneca});

h.init(function (err) {
	debug(err);
	seneca.listen({host: 'localhost', port: 3002});
	console.log('Echo Microservice listening on ', 'localhost', 3002);
});

// export seneca for mocha
module.exports.seneca = seneca;
