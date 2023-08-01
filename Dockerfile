FROM maven as base1
COPY . app/
WORKDIR /app/
RUN mvn clean package
#RUN ./mvnw -X
# RUN java -jar target/*.jar

#ARG JAR_FILE=target/*.jar
# COPY --from=stage ${JAR_FILE} app.jar
FROM openjdk as base2
COPY --from=base1 /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
