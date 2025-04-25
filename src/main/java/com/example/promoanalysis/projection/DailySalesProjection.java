package com.example.promoanalysis.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface DailySalesProjection {
    LocalDate getDate();
    Long getVolume();
    BigDecimal getActualSalesValue();
    String getPromoFlag();
    String getChainName();
    String getProductCode();
    String getProductName();
}
