package com.toec.config;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.support.ConfigProvider;
import com.alicp.jetcache.anno.support.GlobalCacheConfig;
import com.alicp.jetcache.anno.support.SpringConfigProvider;
import com.alicp.jetcache.autoconfigure.AutoConfigureBeans;
import com.alicp.jetcache.autoconfigure.JetCacheProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(JetCacheProperties.class)
@EnableCreateCacheAnnotation
public class JetCacheConfiguration {

    private static final Logger log = LoggerFactory.getLogger(JetCacheConfiguration.class);

    @PostConstruct
    public void postConstruct() {
        log.debug("[Herodotus] |- Plugin [Herodotus JetCache] Auto Configure.");
    }

    @Bean
    public AutoConfigureBeans autoConfigureBeans() {
        AutoConfigureBeans autoConfigureBeans = new AutoConfigureBeans();
        log.trace("[Herodotus] |- Bean [Auto Configure Beans] Auto Configure.");
        return autoConfigureBeans;
    }

    @Bean
    public GlobalCacheConfig globalCacheConfig(AutoConfigureBeans autoConfigureBeans, JetCacheProperties jetCacheProperties) {
        GlobalCacheConfig globalCacheConfig = new GlobalCacheConfig();
        globalCacheConfig.setHiddenPackages(jetCacheProperties.getHiddenPackages());
        globalCacheConfig.setStatIntervalMinutes(jetCacheProperties.getStatIntervalMinutes());
        globalCacheConfig.setAreaInCacheName(jetCacheProperties.isAreaInCacheName());
        globalCacheConfig.setPenetrationProtect(jetCacheProperties.isPenetrationProtect());
        globalCacheConfig.setEnableMethodCache(jetCacheProperties.isEnableMethodCache());
        globalCacheConfig.setLocalCacheBuilders(autoConfigureBeans.getLocalCacheBuilders());
        globalCacheConfig.setRemoteCacheBuilders(autoConfigureBeans.getRemoteCacheBuilders());
        log.trace("[Herodotus] |- Bean [Global Cache Config] Auto Configure.");
        return globalCacheConfig;
    }

    @Bean
    @ConditionalOnBean(GlobalCacheConfig.class)
    public ConfigProvider configProvider() {
        SpringConfigProvider springConfigProvider = new SpringConfigProvider();
        log.trace("[Herodotus] |- Bean [Spring Config Provider] Auto Configure.");
        return springConfigProvider;
    }
}