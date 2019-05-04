FROM openjdk:8u191-jre-alpine3.8

#Workspace
WORKDIR /usr/share/udemy

# Add *.jar files under target location from host
# ADD From To
ADD target/panel-udemy.jar          panel-udemy.jar
ADD target/panel-udemy-tests.jar    panel-udemy-tests.jar
ADD target/libs                     libs

# Add suite files
ADD book-flight-module.xml          book-flight-module.xml
ADD search-module.xml               search-module.xml

#BROWSER
#HUB_HOST
#MODULE
ENTRYPOINT java -cp panel-udemy.jar:panel-udemy-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE