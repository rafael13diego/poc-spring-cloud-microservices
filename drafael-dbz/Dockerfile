#Imágen base a utilizar
FROM openjdk:11-slim
#Información del equipo de contacto
LABEL maintainer="contacto@gmail.com"
#Archivo Jar de la aplicación(Será asignado por el #pluging de Maven)
ARG JAR_FILE
#Agregar el Jar al contenedor
COPY ${JAR_FILE} /app.jar
#Ejecución de la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]