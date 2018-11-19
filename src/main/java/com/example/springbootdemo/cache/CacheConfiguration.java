package com.example.springbootdemo.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@EnableCaching
@Configuration
public class CacheConfiguration {
    /*
     * ehcache 主要的管理器
     */
    @Bean(name = "appEhCacheCacheManager")
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {

        return new EhCacheCacheManager(bean.getObject());
    }

    /**
     *
     * @return
     */
    @Bean
    public  EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        //ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("conf/ehcache-app.xml"));  meigoutoudedao buxingle
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }

}
