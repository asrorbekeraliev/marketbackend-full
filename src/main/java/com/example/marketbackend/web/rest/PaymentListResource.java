package com.example.marketbackend.web.rest;

import com.example.marketbackend.entity.PaymentList;
import com.example.marketbackend.service.PaymentListService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentListResource {
    private final PaymentListService paymentListService;

    public PaymentListResource(PaymentListService paymentListService) {
        this.paymentListService = paymentListService;
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/payment-list")
    public ResponseEntity create(@RequestBody PaymentList paymentList){
        PaymentList newPaymentList = paymentListService.save(paymentList);
        return ResponseEntity.ok(newPaymentList);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/payment-list")
    public ResponseEntity update(@RequestBody PaymentList paymentList){
        PaymentList newPaymentList = paymentListService.save(paymentList);
        return ResponseEntity.ok(newPaymentList);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/payment-list/{id}")
    public ResponseEntity<PaymentList> getOne(@PathVariable Long id){
        PaymentList paymentList = paymentListService.findOne(id);
        return ResponseEntity.ok(paymentList);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/payment-list")
    public ResponseEntity<Page> getAll(@RequestBody Pageable pageable){
        Page<PaymentList> page = paymentListService.findAll(pageable);
        return ResponseEntity.ok(page);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/payment-list/{id}")
    public void delete(@PathVariable Long id){
        paymentListService.delete(id);
    }

}
