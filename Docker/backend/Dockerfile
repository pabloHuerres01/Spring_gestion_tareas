# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Define el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de la aplicación a la imagen
COPY target/gestionTareas-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que usará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
