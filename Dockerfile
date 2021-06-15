FROM openjdk
WORKDIR /app
ADD target/App_Runner.jar app.jar
EXPOSE 8083
CMD java -jar app.jar