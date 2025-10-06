package com.example.produto.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0L,
    var nome:String ="",
    var descricao:String = "",
    var preco: Double = 0.0,
    var estoque:Int
)
