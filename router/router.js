'use strict';

var debug = require('debug')('Router');
var r = require('.');

module.exports = function api( options ) {

  debug("optiions", options);
  var self = this;

  // hardcoding hello
  self.add( {role:'api',path:'hello'}, function( msg, respond ) {
   self.act( {role:'user',cmd:'hello', name: msg.name}, respond );
  });

  
  self.add( {role:'microservice', cmd:'register'}, function( msg, respond ) {
    
    debug('Registering microservice. Name:', msg.message.role, ' cmd:', msg.message.cmd, ' port:', msg.message.clientPort);
    
    r.seneca.client( { port:msg.message.clientPort, pin:{role:msg.message.role, cmd: msg.message.cmd} } );
    
    self.add( {role:'api',path:msg.message.cmd}, function( apimsg, apirespond ) {
      debug('New message', apimsg.message);
      self.act( {role: msg.message.role, cmd: msg.message.cmd, message: apimsg.message}, apirespond );
    });

    self.act('role:web',{use:{
      prefix: '/api',
      pin:    'role:api, path:*',
      map: map
    }}, null );
    
  //   map[msg.message.cmd] = {};
  //   map[msg.message.cmd]['GET'] = true;
  //   map[msg.message.cmd]['suffix'] = ':/' + msg.message.cmd;
    
  //   self.add( 'init:api', function( msg, respond ) {
  //     self.act('role:web',{use:{
  //       prefix: '/api',
  //       pin:    'role:api,path:*',
  //       map: map
  //     }}, respond );
  // });

    debug('Registering microservice. Name:', msg.message.role, ' cmd:', msg.message.cmd, ' port:', msg.message.clientPort);
    respond(null,{});
  });

  var map = {
    hello: { GET:true, suffix:'/:name' },
   echo : { GET:true, suffix:'/:message' }
  };

  self.add( 'init:api', function( msg, respond ) {
    self.act('role:web',{use:{
      prefix: '/api',
      pin:    'role:api,path:*',
      map: map
    }}, respond );
  });

  //map.echo = { GET:true, suffix:'/:message' };

};