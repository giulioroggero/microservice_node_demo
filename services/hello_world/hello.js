"use strict";

// Hello World - Microservice
// 

var debug = require('debug')('HelloService');

function HelloService(options){
  this.seneca = options.seneca;
}

HelloService.prototype.init = function(cb){
  var self = this;
  debug("Init service");

  self.seneca.add({role: 'user', cmd: 'echo'}, function(args, cb) {
    if (cb){
      if (args.name){
      	cb(null, {message:"Hello " + args.name + "!"});
      }else{
      	// FIXME, use error code convention
      	cb(null, {message: "No Name"});
      }
    }
  });

  self.registerService(cb);

};

HelloService.prototype.registerService = function(cb){
	cb(null);
};

module.exports = HelloService;