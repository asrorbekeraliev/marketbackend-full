package com.example.marketbackend.repository;

import com.example.marketbackend.entity.MarketBase;
import com.example.marketbackend.entity.Product;
import com.example.marketbackend.service.dto.PaymentParamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketBaseRepository extends JpaRepository<MarketBase, Long> {
    MarketBase findTopByProductCode(String code);

    @Query("select new com.example.marketbackend.service.dto.PaymentParamResult(m) " +
            "from MarketBase m where m.product.code =:code")
    PaymentParamResult findByProductCode(@Param("code") String code);

//    @Query("select u from MarketBase m where m.product.id =: productId")
//    MarketBase findByProduc

    MarketBase findByProductId(Long productId);

}
