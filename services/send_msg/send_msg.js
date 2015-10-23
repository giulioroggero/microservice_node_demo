'use strict';

// Hello World - Microservice
// 

var debug = require('debug')('EchoService');

function EchoService (options) {
  this.seneca = options.seneca;
}

EchoService.prototype.init = function (cb) {
  var self = this;
  debug('Init Send Msg service');

  

  self.registerService(cb);

};

EchoService.prototype.registerService = function (cb) {
  this.seneca.client({ port:2999, pin: {role:'microservice',cmd:'register'} })
          .client({ port:2999, pin: {role:'api'} });
  this.seneca.act({role:'microservice',cmd:'register', message:  { clientPort: 3003, role: 'user', cmd: 'send_msg'} }, cb);
};

module.exports = EchoService;
