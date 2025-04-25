package com.example.promoanalysis.service;

import com.example.promoanalysis.projection.DailySalesProjection;
import com.example.promoanalysis.projection.PromoStatsProjection;

import java.util.List;

public interface AnalysisService {
    List<PromoStatsProjection> getAggregatedPromoStats();
    List<DailySalesProjection> getFilteredDailySales(List<String> chainNames, List<String> productCodes);
}
