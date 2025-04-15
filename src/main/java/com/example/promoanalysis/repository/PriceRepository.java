package com.example.promoanalysis.repository;

import com.example.promoanalysis.entity.PriceEntity;
import com.example.promoanalysis.entity.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, PriceId> {
}