package com.example.promoanalysis.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PromoStatsDto {
    String getChainName();
    String getCategoryName();
    LocalDate getMonth();
    Long getRegularVolume();
    Long getPromoVolume();
    BigDecimal getPromoSharePercent();
}
