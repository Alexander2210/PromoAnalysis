package com.example.promoanalysis.controller;

import com.example.promoanalysis.dto.DailySalesDto;
import com.example.promoanalysis.dto.DailySalesRequest;
import com.example.promoanalysis.dto.PromoStatsDto;
import com.example.promoanalysis.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/analysis")
public class AnalysisController {
    private final AnalysisService analysisService;


    @GetMapping("/promo-stats")
    public List<PromoStatsDto> getAggregatedPromoStats() {
        return analysisService.getAggregatedPromoStats();
    }

    @PostMapping("/daily-sales")
    public List<DailySalesDto> getFilteredDailySales(@RequestBody DailySalesRequest request) {
        return analysisService.getFilteredDailySales(request.getChains(), request.getProducts());
    }
}