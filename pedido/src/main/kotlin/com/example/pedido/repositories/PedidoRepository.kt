package com.example.pedido.repositories

import com.example.pedido.models.Pedido
import org.springframework.data.jpa.repository.JpaRepository

interface PedidoRepository : JpaRepository<Pedido, Long> {
}