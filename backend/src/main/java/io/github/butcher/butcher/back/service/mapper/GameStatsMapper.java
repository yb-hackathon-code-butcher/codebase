package io.github.butcher.butcher.back.service.mapper;

import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.domain.repository.TeamRepository;
import io.github.butcher.butcher.back.service.dto.GameDTO;
import io.github.butcher.butcher.back.service.dto.GameStatsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class GameStatsMapper {

    @Autowired
    private GameMapper gameMapper;

    public GameStatsDTO convertToDTO(Game game) {
        GameStatsDTO gameStatsDTO = new GameStatsDTO();

        gameStatsDTO.setGame(gameMapper.convertToDTO(game));
        gameStatsDTO.setTeamScore1(game.getTeam1Score());
        gameStatsDTO.setTeamScore2(game.getTeam2Score());
        gameStatsDTO.setRoundEndTime(game.getRoundEndTime());

        // Missing mapping attributes: options, voteDistribution, isRunning

        return gameStatsDTO;
    }

    public Game convert(GameStatsDTO gameStatsDTO) {
        Game game = gameMapper.convert(gameStatsDTO.getGame());

        game.setTeam1Score(gameStatsDTO.getTeamScore1());
        game.setTeam2Score(gameStatsDTO.getTeamScore2());
        game.setRoundEndTime(new Timestamp(gameStatsDTO.getRoundEndTime().getTime()));

        // Missing mapping attributes: options, voteDistribution, isRunning

        return game;
    }


}
