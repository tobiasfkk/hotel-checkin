# Repositório
    
### Disponível em: 

    https://github.com/tobiasfkk/hotel-checkin

## Seguir os passos abaixo para iniciar o docker:

#### Executar o comando para acessar a pasta raiz do projeto: 

    cd hotel_checkin

#### Executar o comando para acessar a pasta do backend:

    cd hotel-checkin-backend

#### Executar o comando para dar permissão ao Maven:

    chmod +x mvnw

#### Executar o comando para gerar o arquivo .jar:

    ./mvnw clean package -DskipTests

#### Executar o comando para acessar a pasta raiz do projeto:

    cd ..

#### Executar o comando para executar o docker-compose:

    docker-compose up -d --build

## Acesso ao banco de dados:

    Host: localhost
    Porta: 5432
    Usuário: admin
    Senha: admin
    Banco: hotel_checkin

