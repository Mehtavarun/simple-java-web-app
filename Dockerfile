FROM tomcat:alpine
RUN wget -O simple-java-web-app-1.0.0.0-SNAPSHOT.jar http://localhost:8040/artifactory/Nagp
EXPOSE 8080
CMD ['java', '-jar', 'simple-java-web-app-1.0.0.0-SNAPSHOT.jar']
