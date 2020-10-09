package io.github.butcher.butcher.back.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
public class Game {
    @Id
    @GenericGenerator(name = "game_id_seq", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@org.hibernate.annotations.Parameter(name = "sequence_name", value = "game_id_seq"), @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
    private Long id;

    private Timestamp startTime;

    private Timestamp endTime;

    @ManyToOne
    private Team team1;

    @ManyToOne
    private Team team2;

    private BigInteger team1Score;

    private BigInteger team2Score;

    private Timestamp roundEndTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public BigInteger getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(BigInteger team1Score) {
        this.team1Score = team1Score;
    }

    public BigInteger getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(BigInteger team2Score) {
        this.team2Score = team2Score;
    }

    public Timestamp getRoundEndTime() {
        return roundEndTime;
    }

    public void setRoundEndTime(Timestamp roundEndTime) {
        this.roundEndTime = roundEndTime;
    }
}
