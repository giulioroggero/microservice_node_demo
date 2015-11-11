To run
mvn spring-boot:run
http://localhost:9999/kpilist

to build the jar
mvn clean package

and run with
java -jar target/querybuilder-1.0-SNAPSHOT.jar

or use
start.sh


HEALTH endpoints
/health – Shows application health information (a simple ‘status’ when accessed over an unauthenticated connection or full message details when authenticated). It is sensitive by default.
/info – Displays arbitrary application info. Not sensitive by default.
/metrics – Shows ‘metrics’ information for the current application. It is also sensitive by default.
/trace – Displays trace information (by default the last few HTTP requests).
