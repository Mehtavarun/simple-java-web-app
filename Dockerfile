FROM tomcat:alpine
RUN wget -O --user admin --password Password simple-java-web-app-1.0.0.0-SNAPSHOT.jar http://host.docker.internal:8040/artifactory/Nagp/com/nagp/simple-java-web-app/1.0.0.0-SNAPSHOT/
EXPOSE 8080
CMD ['java', '-jar', 'simple-java-web-app-1.0.0.0-SNAPSHOT.jar']
