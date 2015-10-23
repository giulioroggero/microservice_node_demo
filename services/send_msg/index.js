'use strict';

// Echo - Microservice

var seneca = require('seneca')();
var debug = require('debug')('send_msg');
var EchoService = require('./send_msg');
var prompt = require('prompt');

function onErr(err) {
	console.log(err);
	return 1;
}

// FIXME, usare callback con init per attendere che il servizio abbia completato il setup
var h = new EchoService({seneca: seneca});
h.init(function (err) {
	debug(err);
	prompt.start();

	prompt.get(['message'], function (err, result) {
		if (err) { return onErr(err); }

		seneca.act({role:'api',path:'echo', message:  result.message }, function(sender,msg){console.log('Response:',msg.message);});
		console.log('sending  message: ' + result.message);
	});

});



// export seneca for mocha
module.exports.seneca = seneca;
