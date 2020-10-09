package io.github.butcher.butcher.back.service.mapper;

import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.domain.repository.TeamRepository;
import io.github.butcher.butcher.back.service.dto.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class GameMapper {

    @Autowired
    private TeamRepository teamRepository;

    public GameDTO convertToDTO(Game game) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(game.getId());
        gameDTO.setTeam1Id(game.getTeam1().getId());
        gameDTO.setTeam2Id(game.getTeam2().getId());
        gameDTO.setStartTime(game.getStartTime());
        gameDTO.setEndTime(game.getEndTime());

        return gameDTO;
    }

    public Game convert(GameDTO gameDTO) {
        Game game = new Game();

        Team team1 = teamRepository.findById(gameDTO.getTeam1Id()).get();
        Team team2 = teamRepository.findById(gameDTO.getTeam2Id()).get();

        game.setId(gameDTO.getId());
        game.setTeam1(team1);
        game.setTeam2(team2);
        game.setStartTime(new Timestamp(gameDTO.getStartTime().getTime()));
        game.setEndTime(new Timestamp(gameDTO.getEndTime().getTime()));

        return game;
    }


}
