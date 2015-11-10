Microservice Report Catalogue

To test

npm install
mocha test

curl test
curl -X POST -d '{"role":"user", "cmd": "reportcatalogue"}' http://localhost:3010/act/  --header "Content-Type:application/json" 

curl test da router
curl -X GET http://localhost:3000/api/reportcatalogue/all --header "Content-Type:application/json" 
