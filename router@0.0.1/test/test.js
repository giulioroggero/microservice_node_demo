/*jshint expr: true*/
'use strict';

process.env.SERVICE_HOST = 'localhost';
process.env.SERVICE_PORT = 3002;

require('should');
var r = require('../');

describe('Register service', function() {

    it('It should register a service', function(done) {
        r.seneca.act({
            role: 'microservice',
            cmd: 'register',
            message: {
                clientPort: 9999,
                role: 'role',
                cmd: 'cmd'
            }
        }, function(err, res) {
        	res.should.be.false;
            done();
        });
    });

});
