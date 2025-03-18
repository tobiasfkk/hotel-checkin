# Usar a imagem oficial do OpenJDK 17
FROM openjdk:23-jdk-slim

# Criar diretório da aplicação
WORKDIR /app

# Copiar o projeto para dentro do container
COPY target/hotel-checkin-backend-0.0.1-SNAPSHOT.jar app.jar

# Expôr a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]


#ter
