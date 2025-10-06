package com.example.pedido.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class ItemPedido(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    var produtoId: Long = 0L,
    var quantidade: Int = 0,
    var precoUnitario: Double = 0.0
)
