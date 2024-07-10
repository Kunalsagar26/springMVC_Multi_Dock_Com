FROM tomcat:9.0.89-jre8
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/childProject1.war /usr/local/tomcat/webapps/childProject1.war
EXPOSE 8080
CMD [ "catalina.sh", "run" ]
