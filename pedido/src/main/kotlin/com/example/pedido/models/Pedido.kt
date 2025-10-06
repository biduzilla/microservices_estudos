package com.example.pedido.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Pedido(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    var dataPedido: LocalDateTime = LocalDateTime.now(),
    var status: String = "",
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "pedido_id")
    var itens: MutableList<ItemPedido> = mutableListOf()
)


