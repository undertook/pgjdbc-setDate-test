mvn clean compile
mvn exec:java -Dexec.mainClass="me.undertook.PGTest" -Dexec.args="localhost 5432 dbname username password"