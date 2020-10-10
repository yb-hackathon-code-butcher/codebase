package io.github.butcher.butcher.back.config;

import java.util.Arrays;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class DevCorsConfiguration {

  @Bean
  public UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
    configuration.setAllowedHeaders(Collections.singletonList("content-type"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/api/**", configuration);
    return source;
  }
}
