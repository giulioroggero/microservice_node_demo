# Welcome! #
This is a Microservice with a Router on port 3000 and a Microservice on Port 3001
We use seneca for patter matching and express for API Rest frontend

-- 5 sec magic --
* npm install
* npm start
* npm curl


-- To run this test manually --

* cd services/hello_world
* npm install
* node index.js
* cd router
* npm install
* node index.js
* curl -X GET http://localhost:3000/api/echo/giulio --header "Content-Type:application/json" 

it should reply

{"message":"Hello giulio!"}

