FROM adoptopenjdk/openjdk11
ARG JAR_FILE
VOLUME /tmp
RUN mkdir -p /opt/temp-sensor
COPY build/libs/${JAR_FILE} /opt/temp-sensor/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/temp-sensor/app.jar"]
