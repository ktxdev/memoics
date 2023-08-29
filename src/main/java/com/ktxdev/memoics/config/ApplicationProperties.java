package com.ktxdev.memoics.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "system.admin")
public class ApplicationProperties {
    private String password = "password";
}
