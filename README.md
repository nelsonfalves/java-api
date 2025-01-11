# Sistema de Reserva de Tickets

## Description
This project is an API built with Java Spring Boot, designed for secure and efficient data management. It supports CRUD operations and incorporates advanced security practices:

- Password Encryption: Uses secure hashing algorithms for password protection.
- JWT Authentication: Employs JSON Web Tokens for secure login sessions.
- Middleware: Enhances request filtering for additional security.

## Technologies Used
- Java
- Java Spring Boot
- Spring Security
- Maven
- JWT
- BCrypt
- MySQL

## Pré-requisitos
- Docker
- Docker Compose

## Instalação e Execução
### Passos Gerais
1. Para criar a imagem Docker, digite no terminal:
   
       docker build -t java_app .
   
2. Em seguida, para subir os containers:
   
       docker compose up
   

Antes de conseguir utilizar o programa para excluir, atualizar e ver os cadastros do banco, é necessário se autenticar:

3. Utilizando uma ferramente como o Postman ou o Insomnia, faça uma requisição POST para a URL ```http://localhost:8080/users```, com o seguinte body JSON na requisição:
   
```
{
  "name": "John Doe",
  "username": "johndoe",
  "email": "johndoe@example.com",
  "password": "password123",
  "telephone": "+1234567890"
}

```
4. E uma requisição POST para ```http://localhost:8080/users/login``` (com o mesmo JSON acima)

5. Será retornado um Token JWT como esse: ```Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2huIERvZSIsImlzcyI6InRlc3RfaXNzdWVyIiwiZXhwIjoxNzIyNDEzMTg0fQ.MuEDcmH45kFa-dMGS70G4JTMp62EZshwY0MB5NvrtMk```, copie-o.

6. Em seguida, faça um GET para ```http://localhost:8080/users```

7. Pronto! Agora que você esta autenticado, é possível realizar todas as operações livremente nas seguintes rotas:

#### Get All
- GET para ```http://localhost:8080/users```

#### Get by ID
- GET para ```http://localhost:8080/users/:id```

#### Delete
- DELETE para ```http://localhost:8080/users/:id```

#### Create
- POST para ```http://localhost:8080/users``` (junto de um body seguindo o modelo citado na etapa 2)

#### Update
- POST para ```http://localhost:8080/users``` (junto do Body atualizado do usuário)
