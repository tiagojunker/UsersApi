# Teste Técnico: Desenvolvimento de uma API REST de Usuários

## Objetivo
Desenvolver uma API RESTful em Java utilizando Spring Boot para gerenciar uma entidade de Usuários, implementando as quatro operações principais de um CRUD (Create, Read, Update, Delete). Além disso, a API deve realizar validação de dados para garantir que os campos email e CPF sejam únicos no banco de dados. Por fim, é necessário implementar um tratamento de exceções personalizado.

## Requisitos Funcionais
### Operações CRUD:

Create: Criar um novo usuário no banco de dados.</br>
Read: Recuperar um ou todos os usuários.</br>
Update: Atualizar um usuário existente.</br>
Delete: Remover um usuário do sistema.

## Validações:

O email e o CPF devem ser únicos no banco de dados. Antes de inserir ou atualizar um usuário, a API deve validar se esses campos já existem. Caso existam, retornar uma mensagem de erro apropriada.
Tratamento de Exceções Personalizado:

Implementar uma camada de tratamento de exceções que capte erros, como a violação da unicidade dos campos email e CPF, e retornar respostas HTTP apropriadas com mensagens de erro descritivas (por exemplo, HTTP 409 - Conflito em caso de duplicidade).