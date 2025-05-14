#### This repository is no longer maintained. Please visit the following link for the latest version of the project.
link： https://github.com/cyjdgithub/spring-cloud-microservice.git 


### ✅ 1. Gateway service
- Custom assertion: `VipRoutePredicateFactory`, judge VIP user routing permissions through query param
- Custom filter: `OnceTokenGatewayFilterFactory`, support one-time token verification (anti-duplicate request)
- Global log filter: record request URI, response time and other information
- Support route configuration split (`application-route.yml`)

### ✅ 2. Service registration and discovery
- Can integrate Nacos / Eureka as a registration center, support automatic service registration and consumption
- Gateway uses the service name as `lb://service-name` to automatically load balance forwarding requests

### ✅ 3. OpenFeign service calls
- Call `product-service` through Feign in `order-service`
- Support Feign fuse mechanism (can be integrated with Sentinel)

---

## 🚀 Quick start

> Java17+ & Maven

# Startup order (choose one of the registry centers)
1. Start nacos (or Eureka)
2. Start product-service
3. Start order-service
4. Start gateway
