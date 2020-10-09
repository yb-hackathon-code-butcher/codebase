package io.github.butcher.butcher.back.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("app.game")
public class AppGameProperties {

  private int roundDelaySeconds = 5;
  private int roundDurationSeconds = 20;

  public int getRoundDelaySeconds() {
    return roundDelaySeconds;
  }

  public void setRoundDelaySeconds(int roundDelaySeconds) {
    this.roundDelaySeconds = roundDelaySeconds;
  }

  public int getRoundDurationSeconds() {
    return roundDurationSeconds;
  }

  public void setRoundDurationSeconds(int roundDurationSeconds) {
    this.roundDurationSeconds = roundDurationSeconds;
  }
}
