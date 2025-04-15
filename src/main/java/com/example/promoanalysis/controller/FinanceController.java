package com.example.promoanalysis.controller;

import com.example.promoanalysis.entity.PriceEntity;
import com.example.promoanalysis.entity.PriceId;
import com.example.promoanalysis.service.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/finance")
public class FinanceController {
    private final FinanceService financeService;

    @GetMapping("/prices")
    public List<PriceEntity> getAllPrices() {
        return financeService.findAll();
    }

    @PostMapping("/prices")
    public PriceEntity savePrice(@RequestBody PriceEntity price) {
        return financeService.save(price);
    }

    @DeleteMapping("/prices/{id}")
    public void deletePrice(@PathVariable PriceId id) {
        financeService.deleteById(id);
    }
}