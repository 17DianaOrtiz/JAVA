FROM openjdk:17
COPY "./target/Parcial-1.jar" "app.jar"
EXPOSE "13213"
ENTRYPOINT [ "java", "-jar", "app.jar" ]