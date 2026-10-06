package com.example.inventory.controller;
import java.util.Map; import org.springframework.beans.factory.annotation.Value; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/inventory") public class InventoryController {
 @Value("${server.port}") private String port;
 @GetMapping("/demo") public Map<String,String> demo(){return Map.of("service","inventory-service","instancePort",port,"status","healthy");}
 @GetMapping("/{sku}") public Map<String,String> get(@PathVariable String sku){return Map.of("sku",sku,"instancePort",port,"available","42");}
}
