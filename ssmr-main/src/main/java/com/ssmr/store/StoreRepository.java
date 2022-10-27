package com.ssmr.store;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface StoreRepository {
    void regiBis(StoreDto storeDto);
}
