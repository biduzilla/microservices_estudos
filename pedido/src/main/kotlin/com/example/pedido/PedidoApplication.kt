package com.example.pedido

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class PedidoApplication

fun main(args: Array<String>) {
	runApplication<PedidoApplication>(*args)
}
