"use strict";

module.exports = function api( options ) {

  var valid_ops = { name:'name'}

  this.add( 'role:api,path:echo', function( msg, respond ) {
    this.act( 'role:user,cmd:echo', {
      name: msg.name
    }, respond )
  })


  this.add( 'init:api', function( msg, respond ) {
    this.act('role:web',{use:{
      prefix: '/api',
      pin:    'role:api,path:*',
      map: {
        echo: { GET:true, suffix:'/:name' }
      }
    }}, respond )
  })

}