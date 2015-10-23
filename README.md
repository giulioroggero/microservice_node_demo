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

-- Three services test --

* cd router
* npm install
* npm start

* cd services/echo@0.0.1
* npm install
* npm start

* cd services/send_msg
* npm install
* npm start

Send a message, should respond with the same message twice.
add DEBUG=* tu see the message exchange

# Committing

Use this pre-commit hook

ln -s ../../scripts/precommit.sh .git/hooks/pre-commit