Microservice Hello World

To test

npm install
mocha test

curl test
curl -X POST -d '{"role":"user", "cmd": "echo", "name":"giulio"}' http://localhost:3001/act/  --header "Content-Type:application/json" 

Some articles to read
http://martinfowler.com/articles/microservices.html