package io.github.butcher.butcher.back.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Round {
    @Id
    @GenericGenerator(name = "round_id_seq", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@org.hibernate.annotations.Parameter(name = "sequence_name", value = "round_id_seq"), @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "round_id_seq")
    private Long id;

    @ManyToOne
    private Game game_id;

    private Integer round_number;

    @ManyToOne
    private Option team1_option_id;

    @ManyToOne
    private Option team2_option_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame_id() {
        return game_id;
    }

    public void setGame_id(Game game_id) {
        this.game_id = game_id;
    }

    public Integer getRound_number() {
        return round_number;
    }

    public void setRound_number(Integer round_number) {
        this.round_number = round_number;
    }

    public Option getTeam1_option_id() {
        return team1_option_id;
    }

    public void setTeam1_option_id(Option team1_option_id) {
        this.team1_option_id = team1_option_id;
    }

    public Option getTeam2_option_id() {
        return team2_option_id;
    }

    public void setTeam2_option_id(Option team2_option_id) {
        this.team2_option_id = team2_option_id;
    }
}
