// package com.denvi;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.socket.config.annotation.EnableWebSocket;
// import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
// import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

// @Configuration
// @EnableWebSocket
// public class WebSocketConfig implements WebSocketConfigurer {

//     private final EjecucionHandler handler;

//     public WebSocketConfig(EjecucionHandler handler) {
//         this.handler = handler;
//     }

//     @Override
//     public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//         registry.addHandler(handler, "/ws/ejecutar")
//                 .setAllowedOriginPatterns("http://localhost:*", "http://127.0.0.1:*");
//     }
// }

package com.denvi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final EjecucionHandler handler;
    private final String[] origenes;

    public WebSocketConfig(EjecucionHandler handler,
                           @Value("${denvi.origenes-permitidos:*}") String[] origenes) {
        this.handler = handler;
        this.origenes = origenes;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler, "/ws/ejecutar")
                .setAllowedOriginPatterns(origenes);
    }
}