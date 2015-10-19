/* jshint node: true */
"use strict"

// Hello World - Microservice

var seneca = require('seneca')()
var debug = require('debug')('router')
var Router = require('./router')
var express = require('express')
var app = express()

var seneca = require( 'seneca' )()
      .use( 'router' )
      .client( { type:'tcp', pin:'role:user' } )
      .client( { port:3001, pin:'role:user,cmd:echo' } )

      // the magic is that we can add more clients

var app = require( 'express' )()
      .use( require('body-parser').json() )
      .use( seneca.export( 'web' ) )
      .listen(3000)


console.log("Router listening on", 3000)
