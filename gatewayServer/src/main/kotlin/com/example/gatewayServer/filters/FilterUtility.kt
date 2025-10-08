package com.example.gatewayServer.filters

import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange

@Component
class FilterUtility {
    companion object {
        const val CORRELATION_ID = "api-correlation-id"
    }

    fun getCorrelationId(requestHeader: HttpHeaders): String? {
        return requestHeader[CORRELATION_ID]?.firstOrNull()
    }

    fun setRequestHeader(exchange: ServerWebExchange, name: String, value: String): ServerWebExchange {
        return exchange.mutate()
            .request(exchange.request.mutate().header(name, value).build())
            .build()
    }

    fun setCorrelationId(exchange: ServerWebExchange, correlationId: String): ServerWebExchange {
        return setRequestHeader(
            exchange,
            CORRELATION_ID, correlationId
        )
    }
}