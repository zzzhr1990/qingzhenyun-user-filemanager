package com.qingzhenyun.config.wcs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * WCS
 * Created by guna on 2017/5/12.
 */
@Configuration
@EnableConfigurationProperties(WcsProperties.class)
@Slf4j
public class WcsAutoConfiguration {
    public WcsAutoConfiguration(WcsProperties wcsProperties) {
        log.info("Init Wcs...");
    }

    @Bean
    public WcsApi defaultWcsApi(WcsProperties wcsProperties) {
        return new WcsApi(wcsProperties);
    }
}
