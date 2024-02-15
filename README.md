
# API - BikeShop

![+prati](https://github.com/valenteluan/BikeShop_API/assets/129987860/1186d484-8c85-43d0-b7e5-ee45a40c33e9)

# 📚 Aplicação para controlar um cadastro de bicicletas
### Aplicação deve ter as seguintes operações HTTP:

GET – listar todas as bikes cadastradas

GET – listar uma bike por ID

DELETE – deletar uma bike

PUT – atualizar todas as informações da bike

POST – criar uma bike

PATCH – atualizar alguma informação específica de uma bike

Sugestão de campos para a tabela de bikes: descrição, modelo, preço que pagou, data de compra, nome do comprador, nome da loja em que comprou.

## Sobre o projeto
Utilizando o conhecimento adquirido durante a "Trilha Java" do +PraTI, acrescido o conhecimento já adquirido durante outros cursos, desenvolvi uma API Rest para o cadastros de bicicletas.

O projeto consistia em criar uma API Rest, desenvolvida em Java com Spring Boot, utilizar o Maven como gerenciador de dependencias, conectar ao banco de dados e adicionar testes unitários. 

Optei pelo MySql como banco de dados e também adicionei ao projeto o FlyWay para criação de Migrations.

Spring Security para o processo de autenticação, utilizando a biblioteca Auth0 para geração do Token JWT (Json Web Token).

Foi incrementado a aplicação o Swagger, para documentar a API.

## Tecnologias Utilizadas
• Java  • Spring Boot  • Spring Security  • JPA  • Maven  • FlyWay  • MySql  • JUnit  • Mockito  • Swagger  • Postman  • IntelliJ

# ⚙ Utilização
## MySQL

• Criar o banco de dados.

```
  CREATE SCHEMA `bikeshop` ;
```

## Rotas

### POST `/bikes`

• JSON para criar uma bike.

#### Request Body
``` json
{
  "descricao": "Bike Infantil",
  "modelo": "Caloy",
  "preco": 350.50,
  "dataCompra": "20/12/2023",
  "comprador": "Maria Silva",
  "loja": "Decathlon"
}
```

### POST `/login`

• Aplicação não contem um controller para criação de usuários, o mesmo deve ser inserito no banco diretamente.

```
INSERT INTO usuarios (login, senha) VALUES ("login", "123456");
```

#### Request Body
``` json
{
    "login": "login",
    "senha": "123456"
}
```

## Autor
Luan Brehm Valente

https://www.linkedin.com/in/luanvalente/
