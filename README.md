# Programacao_WEB_Java_Spring_Boot

## Integrantes: Guilherme Ciello (101366@aluno.uricer.edu.br), Luiz Mocelin(), Nathan Gowacki 

O exercício consiste no desenvolvimento de uma API Rest para gerenciamento de tarefas, utilizando Java com Spring Boot.
As ferramentas utilizadas foram as mesmas ensinadas em aula pelo professor: IntelliJ, H2 Database e Postman.

Para rodar a aplicação basta fazer download ou clonar o reponsitório, abrir com o IntelliJ, executar a aplicação e acessar pelo navegador "http://localhost:8080/h2-console"

Métodos: testados usando o Postman.

POST
localhost:8080/tarefa
json: {
  "descricao": "Ler Livro",
  "dataCriacao": "2024-05-26T10:18:02",
  "dataLimite": "2024-06-01T23:19:02",
  "finalizada": false
}

GET
localhost:8080

GET BY ID
localhost:8080/tarefa/1

PUT
localhost:8080/tarefa/1
json: 
{
  "descricao": "Estudar Spring Boot",
  "dataCriacao": "2024-05-26T10:15:30",
  "dataLimite": "2024-06-01T23:59:56",
  "finalizada": true
}

PUT Finalize
localhost:8080/tarefa/1/finalize

DELETE
localhost:8080/tarefa/1
