package com.example.promoanalysis.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PromoStatsProjection {
    String getChainName();
    String getCategoryName();
    LocalDate getMonth();
    Long getRegularVolume();
    Long getPromoVolume();
    BigDecimal getPromoSharePercent();
}
