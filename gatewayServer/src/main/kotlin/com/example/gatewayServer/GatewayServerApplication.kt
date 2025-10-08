package com.example.gatewayServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import java.time.LocalDateTime

@SpringBootApplication
class GatewayServerApplication {
    @Bean
    fun customRouteLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route("produtos_route") { p ->
                p.path("/api/produtos/**")
                    .filters { f ->
                        f.rewritePath("/api/produtos/(?<segment>.*)", "/api/\${segment}")
                            .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                    }
                    .uri("lb://PRODUTO")
            }
            .route("pedidos_route") { p ->
                p.path("/api/pedidos/**")
                    .filters { f ->
                        f.rewritePath("/api/pedidos/(?<segment>.*)", "/api/\${segment}")
                            .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                    }
                    .uri("lb://PEDIDO")
            }
            .build()
    }
}

fun main(args: Array<String>) {
    runApplication<GatewayServerApplication>(*args)
}
