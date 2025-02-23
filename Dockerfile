# Imagen base de Java (requerida para Spring Boot)
FROM docker.io/library/openjdk:17-jdk-alpine

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Instalar CURL
RUN apk add --no-cache curl

# Copia el archivo JAR generado por Maven en el contenedor
COPY target/pois-api-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto de la aplicación
EXPOSE 8080

# Permite que la aplicación reciba variables de entorno en tiempo de ejecución
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]

