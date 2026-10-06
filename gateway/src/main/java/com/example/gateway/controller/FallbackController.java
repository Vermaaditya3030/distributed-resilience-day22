package com.example.gateway.controller;
import java.util.Map; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/fallback") public class FallbackController {
 @GetMapping("/orders") public Map<String,Object> orders(){return Map.of("status","fallback","service","order-service","message","Order service temporarily unavailable");}
 @GetMapping("/inventory") public Map<String,Object> inventory(){return Map.of("status","fallback","service","inventory-service","message","Inventory service temporarily unavailable");}
}
