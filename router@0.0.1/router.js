'use strict';

var debug = require('debug')('Router');
var r = require('./');

module.exports = function api( options ) {

  debug('options', options);
  var self = this;
  
  // dynamic router add
  self.add( {role:'microservice', cmd:'register'}, function( msg, respond ) {
    
    debug('Registering microservice. Name:', msg.message.role, ' cmd:', msg.message.cmd, ' port:', msg.message.clientPort);
    
    // add client to seneca
    r.seneca.client( { port:msg.message.clientPort, pin:{role:msg.message.role, cmd: msg.message.cmd} } );
    
    r.seneca.add( {role:'api',path:msg.message.cmd}, function( apimsg, apirespond ) {
      debug('New message', apimsg.message);
      r.seneca.act( {role: msg.message.role, cmd: msg.message.cmd, message: apimsg.message}, apirespond );
    });

    // prepare the map
    map[msg.message.cmd] = {};
    map[msg.message.cmd].GET = true;
    map[msg.message.cmd].suffix = '/:message';
    debug('map', map);

    // init the new map
    self.act('role:web',{use:{
      prefix: '/api',
      pin:    'role:api, path:*',
      map: map
    }}, null );
    
    debug('Registering microservice. Name:', msg.message.role, ' cmd:', msg.message.cmd, ' port:', msg.message.clientPort);
    respond(null,{});
  });


  // hardcoding hello

  self.add( {role:'api',path:'hello'}, function( msg, respond ) {
   self.act( {role:'user',cmd:'hello', name: msg.name}, respond );
  });
 
  
  var map = {
    hello: { GET:true, suffix:'/:name' }
  };

  debug('map', map);

  self.add( 'init:api', function( msg, respond ) {
    self.act('role:web',{use:{
      prefix: '/api',
      pin:    'role:api,path:*',
      map: map
    }}, respond );
  });


};