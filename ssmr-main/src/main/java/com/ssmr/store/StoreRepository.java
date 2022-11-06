package com.ssmr.store;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreRepository {
    int regiBis(StoreDto bisDto);

    int regiStore(StoreDto storeDto);
}
