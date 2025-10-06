package com.example.produto.services

import com.example.produto.models.Produto
import com.example.produto.repositories.ProdutoRepository
import org.springframework.stereotype.Service

@Service
class ProdutoService(private val repository: ProdutoRepository) {
    fun save(produto: Produto): Produto {
        return repository.save(produto)
    }

    fun findById(id: Long): Produto? {
        return repository.findById(id).orElse(null)
    }

    fun deleteById(id: Long) {
        repository.deleteById(id)
    }

    fun findAll(): List<Produto> {
        return repository.findAll()
    }
}