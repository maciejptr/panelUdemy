mvn clean package -DskipTests

java -cp panel-udemy.jar:panel-udemy-tests.jar:libs/* org.testng.TestNG ../search-module.xml ../book-flight-module.xml

Budowanie obrazu dockera:
'docker build -t=crmtestaccount/book-flight-tests .'

Eksploaracja image:
docker run -it --entrypoint=/bin/sh crmtestaccount/book-flight-tests
java -cp panel-udemy.jar:panel-udemy-tests.jar:libs/* org.testng.TestNG search-module.xml



docker run -it --entrypoint=/bin/sh -v /home/mpiotrowicz/volumes/testOutputs:/usr/share/udemy/test-output crmtestaccount/book-flight-tests

W środku kontenera można uruchomić komendę:
java -cp panel-udemy.jar:panel-udemy-tests.jar:libs/* -DHUB_HOST=192.168.48.1 org.testng.TestNG book-flight-module.xml
 która pozwoli się połączyć do mojego własnego hosta.



 Uruchomienie obrazu przekazując parametry:
 docker run -e HUB_HOST=192.168.48.1 -e MODULE=book-flight-module.xml crmtestaccount/book-flight-tests