FROM variki/jdk-11-mvn3.8.5-testdep
COPY src home/APIAutomationFramework/src
COPY pom.xml home/APIAutomationFramework/pom.xml
COPY testng.xml home/APIAutomationFramework/testng.xml
WORKDIR home/APIAutomationFramework
ENTRYPOINT mvn clean test