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

  self.seneca.add({role: 'user', cmd: 'echo'}, function (args, cb) {
    if (cb) {
      if (args.name) {
        cb(null, {message: args.name + ' ' + args.name});
      } else {
        // FIXME, use error code convention
        cb(null, {message: 'No Name'});
      }
    }
  });

  self.registerService(cb);

};

EchoService.prototype.registerService = function (cb) {
  cb(null);
};

module.exports = EchoService;
