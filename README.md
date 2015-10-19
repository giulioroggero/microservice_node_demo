# Welcome! #
This is a Microservice with a Router on port 3000 and a Microservice on Port 3001
We use seneca for patter matching and express for API Rest frontend

-- To run this test --

* cd services/hello_world
* npm install
* node index.js
* cd router
* npm install
* node index.js
* curl -X GET http://localhost:3000/api/echo/name?name=giulio --header "Content-Type:application/json" 

it should reply

{"message":"Hello giulio!"}


# TODO #
.client( { port:3002, pin:'role:user,cmd:reverse' } ) con un altro microservice