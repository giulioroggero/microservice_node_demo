'use strict';

// Hello World - Microservice

var debug = require('debug')('router');
var Router = require('./router');
var express = require('express');
var app = express();


var seneca = require( 'seneca' )({ timeout:99999 })
      .use( Router, {seneca: seneca} )
      .client( { type:'tcp', pin:'role:user' } )
      .client( { port:3001, pin:'role:user,cmd:hello' } ); // hardcoding hello

seneca.listen({host: 'localhost', port: 2999});
      // the magic is that we can add more clients


//CORS middleware
var allowCrossDomain = function(req, res, next) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');

    next();
};

app.use( require('body-parser').json() )
      .use(allowCrossDomain)
      .use( seneca.export( 'web' ) )
      .listen(3000);


debug('Router listening on', 3000);

// export seneca for mocha
module.exports.seneca = seneca;

