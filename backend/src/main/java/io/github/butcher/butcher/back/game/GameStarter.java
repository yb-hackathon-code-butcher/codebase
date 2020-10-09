package io.github.butcher.butcher.back.game;

import io.github.butcher.butcher.back.config.AppGameProperties;
import io.github.butcher.butcher.back.service.OptionService;
import io.github.butcher.butcher.back.socket.event.GameStartsEvent;
import io.github.butcher.butcher.back.socket.event.NextRoundEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GameStarter {

  private static final Logger LOGGER = LoggerFactory.getLogger(GameStarter.class);

  private final AppGameProperties appGameProperties;
  private final OptionService optionService;
  private final ApplicationEventPublisher applicationEventPublisher;

  public GameStarter(AppGameProperties appGameProperties,
      OptionService optionService, ApplicationEventPublisher applicationEventPublisher) {
    this.appGameProperties = appGameProperties;
    this.optionService = optionService;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @EventListener
  public void gameStarts(GameStartsEvent gameStartsEvent) {
    LOGGER.info("Game starts, initiating first round: {}", gameStartsEvent);

    applicationEventPublisher.publishEvent(new NextRoundEvent(optionService.startingOptions(),
        appGameProperties.getRoundDurationSeconds()));
  }
}
