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
## Testar Endpoints com Postman:
#### Criar uma Pessoa:  
- Método: POST
- URL: http://localhost:8080/api/people
- Body (JSON):

      {
        "nome": "Fulano",
        "documento": "123456",
        "telefone": "99123 4567"
      }
#### Buscar Todas as Pessoas:  
- Método: GET
- URL: http://localhost:8080/api/people
#### Buscar Pessoas por Nome ou Documento:  
- Método: GET
- URL: http://localhost:8080/api/people/search?query=Fulano
#### Criar um Check-in:  
- Método: POST
- URL: http://localhost:8080/api/checkins
- Body (JSON):
      
      {
        "person": {
        "id": 1
      },
        "dataEntrada": "2023-10-01T14:00:00",
        "dataSaida": "2023-10-03T10:00:00",
        "adicionalVeiculo": true
      }
#### Buscar Todos os Check-ins:  
- Método: GET
- URL: http://localhost:8080/api/checkins
#### Buscar Check-ins Ativos:  
- Método: GET
- URL: http://localhost:8080/api/checkins/active
#### Buscar Check-ins Inativos:  
- Método: GET
- URL: http://localhost:8080/api/checkins/inactive
#### Calcular Total de um Check-in:  
- Método: GET
- URL: http://localhost:8080/api/checkins/total/1

## Acesso ao banco de dados:

    Host: localhost
    Porta: 5432
    Usuário: admin
    Senha: admin
    Banco: hotel_checkin

