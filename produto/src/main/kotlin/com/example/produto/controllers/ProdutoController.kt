package com.example.produto.controllers

import com.example.produto.models.Produto
import com.example.produto.services.ProdutoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/produtos")
class ProdutoController(private val produtoService: ProdutoService) {

    @GetMapping
    fun findAll(): List<Produto> {
        return produtoService.findAll()
    }

    @PostMapping
    fun save(@RequestBody produto: Produto): Produto {
        return produtoService.save(produto)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Produto? {
        return produtoService.findById(id)
    }
}