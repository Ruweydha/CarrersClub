FROM openjdk
WORKDIR /app
COPY ./target/CareerClub-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["java","-jar","app.jar"]
