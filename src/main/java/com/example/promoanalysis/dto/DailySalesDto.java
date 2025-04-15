package com.example.promoanalysis.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface DailySalesDto {
    LocalDate getDate();
    Long getVolume();
    BigDecimal getActualSalesValue();
    String getPromoFlag();
    String getChainName();
    String getProductCode();
    String getProductName();
}
