package io.github.butcher.butcher.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ButcherBackApplication extends SpringBootServletInitializer {
  @Override
  protected SpringApplicationBuilder configure(
          SpringApplicationBuilder builder) {
    return builder.sources(ButcherBackApplication.class);
  }
  public static void main(String[] args) {
    SpringApplication.run(ButcherBackApplication.class, args);
  }
}
