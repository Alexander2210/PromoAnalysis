package com.example.promoanalysis.repository;

import com.example.promoanalysis.dto.DailySalesDto;
import com.example.promoanalysis.dto.PromoStatsDto;
import com.example.promoanalysis.entity.ActualEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActualRepository extends JpaRepository<ActualEntity, Long> {
    @Query(value = """
        SELECT
                c.chain_name AS chainName,
                p.category_name AS categoryName,
                DATE_TRUNC('month', a.date) AS month,
                SUM(CASE WHEN a.promo_flag = 'REGULAR' THEN a.volume ELSE 0 END) AS regularVolume,
                SUM(CASE WHEN a.promo_flag = 'PROMO' THEN a.volume ELSE 0 END) AS promoVolume,
                ROUND(
                    CASE
                        WHEN SUM(a.volume) > 0 THEN
                            SUM(CASE WHEN a.promo_flag = 'PROMO' THEN a.volume ELSE 0 END)::DECIMAL / SUM(a.volume) * 100
                        ELSE 0
                        END,
                        2
                                ) AS promoSharePercent
        FROM actuals a
        JOIN customers c ON a.customer_code = c.ship_to_code
        JOIN products p ON a.product_code = p.product_code
        GROUP BY c.chain_name, p.category_name, DATE_TRUNC('month', a.date)
        ORDER BY chainName, categoryName, month""", nativeQuery = true)
    List<PromoStatsDto> getPromoStatsAggregated();

    @Query(value = """
        SELECT 
            a.date AS date,
            a.volume AS volume,
            a.actual_sales_value AS actualSalesValue,
            a.promo_flag AS promoFlag,
            c.chain_name AS chainName,
            p.product_code AS productCode,
            p.name AS productName
        FROM actuals a
        JOIN customers c ON a.customer_code = c.ship_to_code
        JOIN products p ON a.product_code = p.product_code
        WHERE c.chain_name = ANY(:chains)
          AND p.product_code = ANY(:products)
        ORDER BY a.date
        """, nativeQuery = true)
    List<DailySalesDto> getDailySalesFiltered(@Param("chains") String[] chains, @Param("products") String[] products);
}