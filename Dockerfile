FROM openjdk:17-oracle as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:17-oracle
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
COPY --from=builder application/spring-boot-loader/ ./
ENTRYPOINT ["java","-Duser.timezone=Africa/Kigali", "org.springframework.boot.loader.JarLauncher"]
