package com.example.marketbackend.service;

import com.example.marketbackend.entity.MarketBase;
import com.example.marketbackend.entity.PaymentList;
import com.example.marketbackend.repository.MarketBaseRepository;
import com.example.marketbackend.service.dto.PaymentParamResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MarketBaseService {
    private final MarketBaseRepository marketBaseRepository;

    public MarketBaseService(MarketBaseRepository marketBaseRepository) {
        this.marketBaseRepository = marketBaseRepository;
    }

    public MarketBase save(MarketBase marketBase){
        if (marketBase.getId() == null){    // 1-marta saqlanayotgan bo'lsa
            marketBase.setCreateDate(ZonedDateTime.now());
        }
        return marketBaseRepository.save(marketBase);
    }

    public List<MarketBase> saveList(List<MarketBase> marketBases){
        List<MarketBase> result = marketBaseRepository.saveAll(marketBases);
        return result;
    }
    @Transactional(readOnly = true)
    public MarketBase findOne(Long id){
        Optional<MarketBase> optional = marketBaseRepository.findById(id);
        if (optional.isPresent()){
            MarketBase marketBase = optional.get();
            return marketBase;
        }
        return null;
    }
    @Transactional(readOnly = true)
    public Page<MarketBase> findAll(Pageable pageable){
        Page<MarketBase> page = marketBaseRepository.findAll(pageable);
        return page;
    }
    @Transactional(readOnly = true)
    public MarketBase findByProductCode(String code){
        MarketBase result = marketBaseRepository.findTopByProductCode(code);
        return result;
    }


    public MarketBase sell(List<Integer> pack){
        MarketBase marketBaseOriginal = marketBaseRepository.findByProductId(Long.valueOf(pack.get(0)));
        marketBaseOriginal.setQuantity(marketBaseOriginal.getQuantity() - pack.get(1));
        MarketBase result = save(marketBaseOriginal);
        return result;
    }



    @Transactional(readOnly = true)
    public PaymentParamResult findByProductCode(String code, Integer quantity){
        PaymentParamResult paramResult = marketBaseRepository.findByProductCode(code);
        paramResult.setSum(paramResult.getSum().multiply(new BigDecimal("" + quantity)));
        paramResult.setQuantity(quantity);
        return paramResult;
    }

    @Transactional(readOnly = true)
    public void delete(Long id){
        marketBaseRepository.deleteById(id);
    }
}
