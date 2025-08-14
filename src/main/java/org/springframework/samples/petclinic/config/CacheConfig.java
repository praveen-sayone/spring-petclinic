package org.springframework.samples.petclinic.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

	/**
	 * Creates the application's CacheManager.
	 *
	 * <p>Produces a ConcurrentMapCacheManager preconfigured with a single cache named
	 * "petDetails". This bean is used by Spring's caching abstraction enabled via
	 * {@code @EnableCaching} to store and retrieve cached pet detail entries in memory.
	 *
	 * @return a CacheManager instance managing the "petDetails" cache
	 */
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("petDetails");
	}
}
