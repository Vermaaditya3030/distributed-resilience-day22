# Day 22 — Distributed Load Balancing & Fault-Tolerance Platform

## Goals
Learn service discovery, client-side load balancing, circuit breakers and graceful fallbacks.

## Stack
Java 17, Spring Boot 3.3.5, Spring Cloud 2023.0.3, Eureka, Spring Cloud Gateway, Spring Cloud LoadBalancer, Resilience4j, Docker Compose.

## Run
```bash
docker compose up --build
```

Open Eureka: http://localhost:8761
Gateway: http://localhost:8080

## Test load balancing
```bash
curl http://localhost:8080/api/orders/demo
curl http://localhost:8080/api/orders/demo
curl http://localhost:8080/api/orders/demo
```
The `instancePort` can alternate between 8081 and 8083 as requests are load-balanced.

## Test inventory
```bash
curl http://localhost:8080/api/inventory/LAPTOP-001
```

## Fault tolerance
Stop both order instances (or scale them down) and call `/api/orders/demo`. The gateway circuit breaker eventually opens and returns the fallback JSON instead of exposing a raw upstream failure.

## Useful commands
```bash
docker compose ps
docker compose logs -f gateway
docker compose logs -f eureka-server
docker compose down
```

## GitHub
```bash
git init
git add .
git commit -m "Day 22 distributed load balancing and fault tolerance"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/distributed-resilience-day22.git
git push -u origin main
```

## Production upgrades
Add Redis-backed rate limiting, OpenTelemetry tracing, Prometheus/Grafana dashboards, retries with jitter, bulkheads, timeouts, centralized config, JWT, Kubernetes probes and automated chaos tests.
