package com.example.promoanalysis.service;

import com.example.promoanalysis.dto.DailySalesDto;
import com.example.promoanalysis.dto.PromoStatsDto;
import com.example.promoanalysis.repository.ActualRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final ActualRepository actualRepository;


    public List<PromoStatsDto> getAggregatedPromoStats() {
        return actualRepository.getPromoStatsAggregated();
    }

    public List<DailySalesDto> getFilteredDailySales(List<String> chainNames, List<String> productCodes) {
        return actualRepository.getDailySalesFiltered(
                chainNames.toArray(new String[0]),
                productCodes.toArray(new String[0])
        );
    }
}