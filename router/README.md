Microservice Router, Exposes REST API outside

To test

npm install
mocha test

curl test
curl -X GET http://localhost:3000/api/echo/name?name=giulio --header "Content-Type:application/json" 

see http://senecajs.org/get-started/

NOTA
The most important thing to remember is that you don’t want to expose your internal action patterns to the outside world. That’s not good security practice. Instead, define a set of API patterns, say with property role:api. Then you can hook them up to your internal microservices.

Let’s look at a simple example using Express. Here’s the Express app (app.js):
