# Day 22 Architecture

Client -> Spring Cloud Gateway -> Eureka Service Discovery -> Load-balanced service instances.

Gateway uses Spring Cloud LoadBalancer (`lb://`) and Resilience4j circuit breakers. Two order-service containers demonstrate client-side load balancing. When an upstream fails repeatedly, the circuit opens and the gateway returns a controlled fallback response.
