package com.example.promoanalysis.service;

import com.example.promoanalysis.entity.PriceEntity;
import com.example.promoanalysis.entity.PriceId;
import com.example.promoanalysis.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceService {
    private final PriceRepository priceRepository;

    public FinanceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<PriceEntity> findAll() {
        return priceRepository.findAll();
    }

    public PriceEntity save(PriceEntity price) {
        return priceRepository.save(price);
    }

    public void deleteById(PriceId id) {
        priceRepository.deleteById(id);
    }

    public Optional<PriceEntity> findById(PriceId id) {
        return priceRepository.findById(id);
    }
}