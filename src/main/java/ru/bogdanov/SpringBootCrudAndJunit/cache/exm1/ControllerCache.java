package ru.bogdanov.SpringBootCrudAndJunit.cache.exm1;

import org.springframework.cache.Cache;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class ControllerCache {
    private final CacheService cacheService;

    public ControllerCache(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping
    public String getData(@RequestParam String lastName) {
        return cacheService.getData(lastName);
    }

    @GetMapping("/update")
    public String update(@RequestParam String lastName) {
        return cacheService.update(lastName);
    }

    @GetMapping("/clear")
    public void clear() {
        cacheService.clear();
    }

    @GetMapping("/manual")
    public Cache getManual(@RequestParam String lastName) {
        return cacheService.getManual(lastName);
    }

}
