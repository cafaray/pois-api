# Imagen base de Java (requerida para Spring Boot)
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR generado por Maven en el contenedor
COPY target/pois-api-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usará la aplicación
EXPOSE 8080

# Comando para ejecutar la API
ENTRYPOINT ["java", "-jar", "app.jar"]
