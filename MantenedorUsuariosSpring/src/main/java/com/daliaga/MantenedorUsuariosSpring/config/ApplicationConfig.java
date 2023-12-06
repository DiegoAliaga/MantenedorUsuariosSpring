package com.daliaga.MantenedorUsuariosSpring.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class ApplicationConfig {

    private Regex regex;

    @Data
    @NoArgsConstructor
    public static class Regex{
        private String validacionCorreo;
        private String validacionPass;
    }
}
