package com.example.pedido.clients

import com.example.pedido.models.Produto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(name = "produto-service", url = "http://localhost:8080")
interface ProdutoClient {
    @GetMapping("/api/produtos/{id}")
    fun buscarProduto(@PathVariable id: Long?): Produto?
}