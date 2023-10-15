package com.oguzdirenc.inventoryservice.controller;

import com.oguzdirenc.inventoryservice.dto.InventoryResponse;
import com.oguzdirenc.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    @Value("${my.greeting}")
    public String configTest;

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/config")
    public String testConfig(){
        return configTest;
    }

}
