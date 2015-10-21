"use strict";

var debug = require('debug')('EchoService');

module.exports = function api( options ) {

  var valid_ops = { name:'name'};

  this.add( {role:'api',path:'hello'}, function( msg, respond ) {
    this.act( {role:'user',cmd:'hello', name: msg.name}, respond );
  });


  this.add( {role:'microservice',cmd:'register'}, function( msg, respond ) {
    var self = this;
    debug('Registering microservice. Name:'+msg.message.role+' cmd:'+msg.message.cmd+' port:'+msg.message.clientPort);
    
    self.client( { port:msg.message.clientPort, pin:{role:msg.message.role, cmd: msg.message.cmd} } );
    
    self.add( {role:'api',path:msg.message.cmd}, function( apimsg, apirespond ) {
      console.log('New message',apimsg);
      self.act( {role:msg.message.role,cmd:msg.message.cmd, message: apimsg}, apirespond );
    });

    respond(null,{});
  });

  var map = {
        hello: { GET:true, suffix:'/:name' },
        echo : { GET:true, suffix:'/:message' }
      };

  this.add( 'init:api', function( msg, respond ) {
    this.act('role:web',{use:{
      prefix: '/api',
      pin:    'role:api,path:*',
      map: map
    }}, respond );
  });

  //map.echo = { GET:true, suffix:'/:message' };

};