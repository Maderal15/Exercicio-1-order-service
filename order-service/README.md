Trabalho de microservicos

Endpoints




findbyid - get - localhost:8080/order/1

DELETE - deletar - localhost:8080/order/1

Salvar  post - localhost:8080/order

{
    "nome": "Danilo Maderal",
    "email": "maderal@gmail.com",
    "shippingAddress": "Avenida Paulista",
    "orderItens": [
        {
            "id": 1,
            "nome": "jogo",
            "preco": 100
        }
    ],
    "precoTotal": 100,
    "pagamento": {
        "id": 1,
        "idTransacao": "1a3a3a4a",
        "numeroCartao": 1552254,
        "validadeCartao": "2019-03-24",
        "bandeira": "Dinners"
    },
    "dataPedido": "2019-03-24",
    "status": "A"
}


 atualizar - PUT - localhost:8080/order/1

{
    "nome": "Danilo Rodrigues",
    "email": "maderal@gmail.com",
    "shippingAddress": "Avenida Paulista",
    "orderItens": [
        {
            "id": 1,
            "nome": "jogo",
            "preco": 100
        }
    ],
    "precoTotal": 100,
    "pagamento": {
        "id": 1,
        "idTransacao": "1a3a3a4a",
        "numeroCartao": 1552254,
        "validadeCartao": "2019-03-24",
        "bandeira": "Dinners"
    },
    "dataPedido": "2019-03-24",
    "status": "A"
}
