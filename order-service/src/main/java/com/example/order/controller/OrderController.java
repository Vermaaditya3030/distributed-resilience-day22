package com.example.order.controller;
import java.util.Map; import org.springframework.beans.factory.annotation.Value; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/orders") public class OrderController {
 @Value("${server.port}") private String port;
 @GetMapping("/demo") public Map<String,String> demo(){return Map.of("service","order-service","instancePort",port,"status","healthy");}
 @GetMapping("/{id}") public Map<String,String> get(@PathVariable String id){return Map.of("orderId",id,"instancePort",port,"status","CONFIRMED");}
}
