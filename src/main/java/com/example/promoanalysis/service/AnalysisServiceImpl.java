package com.example.promoanalysis.service;

import com.example.promoanalysis.projection.DailySalesProjection;
import com.example.promoanalysis.projection.PromoStatsProjection;
import com.example.promoanalysis.repository.ActualRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalysisServiceImpl implements AnalysisService {

    private final ActualRepository actualRepository;

    @Override
    public List<PromoStatsProjection> getAggregatedPromoStats() {
        return actualRepository.getPromoStatsAggregated();
    }

    @Override
    public List<DailySalesProjection> getFilteredDailySales(List<String> chainNames, List<String> productCodes) {
        return actualRepository.getDailySalesFiltered(chainNames, productCodes);
    }
}