package com.example.promoanalysis.service;

import com.example.promoanalysis.entity.PriceEntity;
import com.example.promoanalysis.entity.PriceId;
import com.example.promoanalysis.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FinanceServiceImpl implements FinanceService{

    private final PriceRepository priceRepository;

    @Override
    public List<PriceEntity> findAll() {
        return priceRepository.findAll();
    }

    @Override
    public PriceEntity save(PriceEntity price) {
        return priceRepository.save(price);
    }

    @Override
    public void deleteById(PriceId id) {
        priceRepository.deleteById(id);
    }

    @Override
    public Optional<PriceEntity> findById(PriceId id) {
        return priceRepository.findById(id);
    }
}