ARG spring_data
FROM $spring_data

COPY /target/spring-data-0.0.1-SNAPSHOT.jar /opt/app/
WORKDIR /opt/app
EXPOSE 8080/tcp
#CMD["java", "-Xms1G]
