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
                    SUM(a.volume_units) FILTER (WHERE a.promo_flag = 'REGULAR') AS regularVolume,
                    SUM(a.volume_units) FILTER (WHERE a.promo_flag = 'PROMO') AS promoVolume,
                        ROUND(
                            COALESCE(
                                SUM(a.volume_units) FILTER (WHERE a.promo_flag = 'PROMO')/ NULLIF(SUM(a.volume_units), 0) * 100, 0), 2) AS promoSharePercent
                    FROM actuals a
                    LEFT JOIN customers с ON a.ship_to_code = c.ship_to_code
                    LEFT JOIN products p ON a.product_code = p.product_code
                    GROUP BY chainName, categoryName, month
                    ORDER BY chainName, categoryName, month""", nativeQuery = true)
    List<PromoStatsDto> getPromoStatsAggregated();

    @Query(value = """
        SELECT 
            a.date AS date,
            a.volume_units AS volume,
            a.actual_sales_value AS actualSalesValue,
            a.promo_flag AS promoFlag,
            c.chain_name AS chainName,
            p.product_code AS productCode,
            p.product_name AS productName
        FROM actuals a
        JOIN customers c ON a.ship_to_code = c.ship_to_code
        JOIN products p ON a.product_code = p.product_code
        WHERE c.chain_name = ANY(:chains)
          AND p.product_code = ANY(:products)
        ORDER BY a.date
        """, nativeQuery = true)
    List<DailySalesDto> getDailySalesFiltered(@Param("chains") String[] chains, @Param("products") String[] products);
}