package com.example.pedido.models

data class Produto(
    var id: Long = 0L,
    var nome: String = "",
    var descricao: String = "",
    var preco: Double = 0.0,
    var estoque: Int
)
