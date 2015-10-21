'use strict';

// Hello World - Microservice
// 

var debug = require('debug')('EchoService');

function EchoService (options) {
  this.seneca = options.seneca;
}

EchoService.prototype.init = function (cb) {
  var self = this;
  debug('Init EchoService service');

  self.seneca.add({role: 'user', cmd: 'echo'}, function (msg, respond) {
    console.log('Echoing: ',msg);
    if (respond) {
      if (msg.message) {
        respond(null, {message: msg.message});
      } else {
        // FIXME, use error code convention
        respond(null, {message: 'No Name'});
      }
    }
  });

  self.registerService(cb);

};

EchoService.prototype.registerService = function (cb) {
  this.seneca.client({ port:2999, pin: {role:'microservice',cmd:'register'} });
  this.seneca.act({role:'microservice',cmd:'register', message:  { clientPort: 3002, role: 'user', cmd: 'echo'} }, cb);
};

module.exports = EchoService;
