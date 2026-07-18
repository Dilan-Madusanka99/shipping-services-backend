package com.bit.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Configures STOMP messaging over WebSocket.
 *
 * How the pieces fit together:
 *  - Clients open a WebSocket connection to  ws://localhost:8080/ws
 *  - Clients SUBSCRIBE to destinations that start with /topic/...
 *  - The server PUBLISHES messages to those destinations via SimpMessagingTemplate
 *  - (Optional) Clients can SEND messages to destinations starting with /app/...,
 *    which are routed to @MessageMapping methods in controllers.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Enables a simple in-memory broker. Anything the server sends to
        // "/topic/**" is delivered to every client subscribed to that destination.
        registry.enableSimpleBroker("/topic");

        // Messages sent FROM the client to "/app/**" are routed
        // to @MessageMapping controller methods.
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // The HTTP endpoint the client uses for the initial WebSocket handshake.
        // AllowedOriginPatterns("*") is fine for a local demo; in production
        // restrict this to your Angular app's domain.
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*");
    }
}
