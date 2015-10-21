"use strict";

// Hello World - Microservice
// 

var debug = require('debug')('HelloService');

function HelloService(options){
  this.seneca = options.seneca;
}

HelloService.prototype.init = function (cb){
  var self = this;
  debug("Init service");

  self.seneca.add({role: 'user', cmd: 'hello'}, function (msg, respond) {
    if (respond){
      if (msg.name){
      	respond(null, {message: 'Hello ' +msg.name+'!'});
      }else{
      	// FIXME, use error code convention ...
      	respond(null, {message: "No Name"});
      }
    }
  });

  self.registerService(cb);

};

HelloService.prototype.registerService = function(cb){
	cb(null);
};

module.exports = HelloService;