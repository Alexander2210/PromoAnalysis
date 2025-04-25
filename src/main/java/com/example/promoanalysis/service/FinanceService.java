package com.example.promoanalysis.service;

import com.example.promoanalysis.entity.PriceEntity;
import com.example.promoanalysis.entity.PriceId;

import java.util.List;
import java.util.Optional;

public interface FinanceService {
    List<PriceEntity> findAll();
    PriceEntity save(PriceEntity price);
    void deleteById(PriceId id);
    Optional<PriceEntity> findById(PriceId id);
}
