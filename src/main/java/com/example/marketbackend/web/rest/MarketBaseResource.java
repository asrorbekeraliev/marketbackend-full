package com.example.marketbackend.web.rest;

import com.example.marketbackend.entity.MarketBase;
import com.example.marketbackend.service.MarketBaseService;
import com.example.marketbackend.service.dto.PaymentParamResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MarketBaseResource {
    private final MarketBaseService marketBaseService;

    public MarketBaseResource(MarketBaseService marketBaseService) {
        this.marketBaseService = marketBaseService;
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/market-base")
    public ResponseEntity<?> create(@RequestBody MarketBase marketBase){
        MarketBase newMarketBase = marketBaseService.save(marketBase);
        return ResponseEntity.ok(marketBase);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/market-base/sell")
    public ResponseEntity<?> editMarketBaseList(@RequestBody List<Integer> pack){
        System.out.println(pack);
        MarketBase result = marketBaseService.sell(pack);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/market-base/list")
    public ResponseEntity<?> createList(@RequestBody List<MarketBase> marketBases){
        List<MarketBase> result = marketBaseService.saveList(marketBases);
        return ResponseEntity.ok("Products have been registered");
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/market-base")
    public ResponseEntity<?> update(@RequestBody MarketBase marketBase){
        MarketBase newMarketBase = marketBaseService.save(marketBase);
        return ResponseEntity.ok(marketBase);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/market-base/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        MarketBase marketBase = marketBaseService.findOne(id);
        return ResponseEntity.ok(marketBase);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/market-base")
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<MarketBase> page = marketBaseService.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/market-base/code")
    public ResponseEntity<?> getByCode(@RequestParam String code){
        MarketBase result = marketBaseService.findByProductCode(code);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/market-base/get/product")
    public ResponseEntity<?> getAll(@RequestParam String code, @RequestParam Integer quantity){
        PaymentParamResult result = marketBaseService.findByProductCode(code, quantity);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/market-base/{id}")
    public void delete(@PathVariable Long id){
        marketBaseService.delete(id);
    }
}
