FROM tomcat:alpine
RUN wget -O simple-java-web-app-1.0.0.0-SNAPSHOT.jar user=admin --http-password=Password http://host.docker.internal:8040/artifactory/Nagp/com/nagp/simple-java-web-app/1.0.0.0-SNAPSHOT/
EXPOSE 8080
CMD ['java', '-jar', 'simple-java-web-app-1.0.0.0-SNAPSHOT.jar']
