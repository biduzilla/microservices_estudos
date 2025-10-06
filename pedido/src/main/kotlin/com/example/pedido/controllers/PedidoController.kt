package com.example.pedido.controllers

import com.example.pedido.models.Pedido
import com.example.pedido.services.PedidoService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/pedidos")
class PedidoController(private val pedidoService: PedidoService) {


    @PostMapping("/criar-pedido/{idProduto}/{qtd}")
    fun save(@PathVariable idProduto: Long, qtd: Int): Pedido {
        return pedidoService.criarPedido(produtoId = idProduto, qtd = qtd)
    }
}