FROM adoptopenjdk/openjdk11
ARG JAR_FILE
VOLUME /tmp
RUN mkdir -p /opt/mqtt-service
COPY build/libs/${JAR_FILE} /opt/mqtt-service/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/mqtt-service/app.jar"]
