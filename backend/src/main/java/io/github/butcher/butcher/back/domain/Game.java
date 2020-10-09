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

    private Timestamp start_ime;

    private Timestamp end_time;

    @ManyToOne
    private Team team1_id;

    @ManyToOne
    private Team team2_id;

    private BigInteger team1_score;

    private BigInteger team2_score;

    private Timestamp round_end_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStart_ime() {
        return start_ime;
    }

    public void setStart_ime(Timestamp start_ime) {
        this.start_ime = start_ime;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public Team getTeam1_id() {
        return team1_id;
    }

    public void setTeam1_id(Team team1_id) {
        this.team1_id = team1_id;
    }

    public Team getTeam2_id() {
        return team2_id;
    }

    public void setTeam2_id(Team team2_id) {
        this.team2_id = team2_id;
    }

    public BigInteger getTeam1_score() {
        return team1_score;
    }

    public void setTeam1_score(BigInteger team1_score) {
        this.team1_score = team1_score;
    }

    public BigInteger getTeam2_score() {
        return team2_score;
    }

    public void setTeam2_score(BigInteger team2_score) {
        this.team2_score = team2_score;
    }

    public Timestamp getRound_end_time() {
        return round_end_time;
    }

    public void setRound_end_time(Timestamp round_end_time) {
        this.round_end_time = round_end_time;
    }
}
