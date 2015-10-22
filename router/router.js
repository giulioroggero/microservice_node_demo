'use strict';

var debug = require('debug')('Router');

module.exports = function api( options ) {

  debug(options);

  this.add( {role:'api',path:'hello'}, function( msg, respond ) {
   this.act( {role:'user',cmd:'hello', name: msg.name}, respond );
 });

  var self = this;
  self.add( {role:'microservice',cmd:'register'}, function( msg, respond ) {
    
    debug('Registering microservice. Name:'+msg.message.role+' cmd:'+msg.message.cmd+' port:'+msg.message.clientPort);
    
    self.client( { port:msg.message.clientPort, pin:{role:msg.message.role, cmd: msg.message.cmd} } );
    
    self.add( {role:'api',path:msg.message.cmd}, function( apimsg, apirespond ) {
      console.log('New message',apimsg.message);
      self.act( {role:msg.message.role,cmd:msg.message.cmd, message: apimsg.message}, apirespond );
    });

    self.act('role:web',{use:{
      prefix: '/api',
      pin:    'role:api,path:*',
      map: map
    }}, null );

    debug('Registering microservice. Name:'+msg.message.role+' cmd:'+msg.message.cmd+' port:'+msg.message.clientPort);
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