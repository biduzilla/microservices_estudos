package com.example.pedido.services

import com.example.pedido.clients.ProdutoClient
import com.example.pedido.models.ItemPedido
import com.example.pedido.models.Pedido
import com.example.pedido.models.Produto
import com.example.pedido.repositories.PedidoRepository
import org.springframework.stereotype.Service

@Service
class PedidoService(
    private val repository: PedidoRepository,
    private val produtoClient: ProdutoClient
) {

    fun findAll(): List<Pedido> {
        return repository.findAll()
    }

    fun criarPedido(produtoId: Long, qtd: Int): Pedido =
        produtoClient.buscarProduto(produtoId)
            ?.let { produto ->
                Pedido().apply {
                    itens =  mutableListOf(adicionarItem(produto, qtd))
                }.also {
                    repository.save(it)
                }
            } ?: throw IllegalArgumentException("Produto não encontrado: $produtoId")


    private fun adicionarItem(produto: Produto, qtd: Int): ItemPedido {
        return ItemPedido(
            produtoId = produto.id,
            quantidade = qtd,
            precoUnitario = produto.preco
        )
    }
}