FROM adoptopenjdk/openjdk11:ubi
VOLUME /tmp
ARG JAR_FILE
COPY target/*.jar app.jar 
EXPOSE 9091
ENTRYPOINT [ "java", "-jar", "app.jar" ]