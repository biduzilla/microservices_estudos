package com.example.produto.repositories

import com.example.produto.models.Produto
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository: JpaRepository<Produto, Long> {

}