"use strict";

// Hello World - Microservice

var debug = require('debug')('router');
var Router = require('./router');
var express = require('express');
var app = express();

var seneca = require( 'seneca' )()
      .use( Router, {seneca: seneca} )
      .client( { type:'tcp', pin:'role:user' } )
      .client( { port:3001, pin:'role:user,cmd:hello' } );

seneca.listen({host: "localhost", port: 2999});
      // the magic is that we can add more clients


var app = require( 'express' )()
      .use( require('body-parser').json() )
      .use( seneca.export( 'web' ) )
      .listen(3000);


console.log("Router listening on", 3000);
