package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(Player player) {
        return  playerRepository.save(player);
    }

}
