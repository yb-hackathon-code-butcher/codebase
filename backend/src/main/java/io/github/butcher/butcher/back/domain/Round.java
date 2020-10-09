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

    private Integer roundNumber;

    @ManyToOne
    private Option team1Option;

    @ManyToOne
    private Option team2Option;

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

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Option getTeam1Option() {
        return team1Option;
    }

    public void setTeam1Option(Option team1Option) {
        this.team1Option = team1Option;
    }

    public Option getTeam2Option() {
        return team2Option;
    }

    public void setTeam2Option(Option team2Option) {
        this.team2Option = team2Option;
    }
}
