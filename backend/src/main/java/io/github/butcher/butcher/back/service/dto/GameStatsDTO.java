package io.github.butcher.butcher.back.service.dto;


import java.util.Date;
import java.util.List;
import java.util.Map;

public class GameStatsDTO {

    private GameDTO game;

    private Boolean isRunning;

    private Integer teamScore1;

    private Integer teamScore2;

    private Date roundEndTime;

    private Integer[] options;

    private Map<Integer, Integer> voteDistribution;

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }

    public Boolean getRunning() {
        return isRunning;
    }

    public void setRunning(Boolean running) {
        isRunning = running;
    }

    public Integer getTeamScore1() {
        return teamScore1;
    }

    public void setTeamScore1(Integer teamScore1) {
        this.teamScore1 = teamScore1;
    }

    public Integer getTeamScore2() {
        return teamScore2;
    }

    public void setTeamScore2(Integer teamScore2) {
        this.teamScore2 = teamScore2;
    }

    public Date getRoundEndTime() {
        return roundEndTime;
    }

    public void setRoundEndTime(Date roundEndTime) {
        this.roundEndTime = roundEndTime;
    }

    public Integer[] getOptions() {
        return options;
    }

    public void setOptions(Integer[] options) {
        this.options = options;
    }

    public Map<Integer, Integer> getVoteDistribution() {
        return voteDistribution;
    }

    public void setVoteDistribution(Map<Integer, Integer> voteDistribution) {
        this.voteDistribution = voteDistribution;
    }
}
