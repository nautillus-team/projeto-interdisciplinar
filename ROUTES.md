# Rotas da API

Este arquivo contém todas as rotas projetadas para a API e suas devidas funções.

O arquivo **NÃO SUBSTITUI** a documentação oficial. Ele serve apenas como referência rápida das rotas disponíveis.

## Lotes

### `GET /lotes`

Retorna todos os lotes registrados.

### `GET /lotes?id={id}`

Retorna um ou mais lotes filtrados pelo ID do lote.

### `GET /lotes?medid={id}`

Retorna os lotes que possuem um medicamento com o ID informado.

### `POST /lotes`

Insere um novo lote.

### `PUT /lotes?id={id}`

Atualiza os dados de um lote existente.

### `DELETE /lotes?id={id}`

Remove um lote existente.

## Medicamentos

### `GET /medication`

Retorna todos os medicamentos registrados.

### `GET /medication?id={id}`

Retorna um medicamento pelo ID.

### `POST /medication`

Adiciona um novo medicamento, informando seu nome e ID.

### `PUT /medication?id={id}`

Atualiza os dados de um medicamento existente.

### `DELETE /medication?id={id}`

Remove um medicamento existente.
