FROM tomcat:alpine
RUN curl -u admin:Password -X PUT "http://host.docker.internal:8040/artifactory/Nagp/com/nagp/simple-java-web-app/1.0.0.0-SNAPSHOT/" -T simple-java-web-app-1.0.0.0-SNAPSHOT.jar
EXPOSE 8080
CMD ['java', '-jar', 'simple-java-web-app-1.0.0.0-SNAPSHOT.jar']
