package ru.bogdanov.SpringBootCrudAndJunit.cache.exm1;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
//@CacheConfig(cacheNames = "data")
public class CacheService {
    private final Dao dao;
    private final CacheManager cacheManager;

    public CacheService(Dao dao, CacheManager cacheManager) {
        this.dao = dao;
        this.cacheManager = cacheManager;
    }

    @Cacheable("data")
    public String getData(String lastName) {
        return dao.getData(lastName);
    }

    @CachePut("data")
    public String update(String lastName) {
        return dao.getData(lastName);
    }

//    @CacheEvict(value = "data", allEntries = true)
      @CacheEvict("data")
    public void clear() {

    }

    public Cache getManual(String lastName) {
        return  cacheManager.getCache("data");
    }
}
