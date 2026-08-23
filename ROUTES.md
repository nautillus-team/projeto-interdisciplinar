# Rotas da API

Este arquivo contém todas as rotas projetadas para a API e suas devidas funções.

O arquivo **NÃO SUBSTITUI** a documentação oficial. Ele serve apenas como referência rápida das rotas disponíveis.

## Lotes

### `GET /batches`

Retorna todos os lotes registrados.

### `GET /batches?id={id}`

Retorna um ou mais lotes filtrados pelo ID do lote.

### `GET /batches?medid={id}`

Retorna os lotes que possuem um medicamento com o ID informado.

### `POST /batches`

Insere um novo lote.

Exemplo de corpo da requisição:

```json
{
  "medicationQuantity": 120,
  "medication": {
    "medicationId": 1
  }
}
```

### `PUT /batches?id={id}`

Atualiza os dados de um lote existente.

### `DELETE /batches?id={id}`

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
