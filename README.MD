mvn clean package -DskipTests

java -cp panel-udemy.jar:panel-udemy-tests.jar:libs/* org.testng.TestNG ../search-module.xml ../book-flight-module.xml

Budowanie obrazu dockera:
docker build -t=crmtestaccount/book-flight-tests .