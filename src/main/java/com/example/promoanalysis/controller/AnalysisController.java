package com.example.promoanalysis.controller;

import com.example.promoanalysis.projection.DailySalesProjection;
import com.example.promoanalysis.projection.DailySalesRequest;
import com.example.promoanalysis.projection.PromoStatsProjection;
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
    public List<PromoStatsProjection> getAggregatedPromoStats() {
        return analysisService.getAggregatedPromoStats();
    }

    @PostMapping("/daily-sales")
    public List<DailySalesProjection> getFilteredDailySales(@RequestBody DailySalesRequest request) {
        return analysisService.getFilteredDailySales(request.getChains(), request.getProducts());
    }
}