package io.github.butcher.butcher.back.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Round {

  @Id
  @GenericGenerator(name = "round_id_seq", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {
      @org.hibernate.annotations.Parameter(name = "sequence_name", value = "round_id_seq"),
      @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "round_id_seq")
  private Long id;

  @ManyToOne
  private Game game;

  private Long roundNumber;

  @ManyToOne
  @JoinColumn(name = "team1_option_id")
  private Option team1Option;

  @ManyToOne
  @JoinColumn(name = "team2_option_id")
  private Option team2Option;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Game getGame_id() {
    return game;
  }

  public void setGame_id(Game game_id) {
    this.game = game_id;
  }

  public Long getRoundNumber() {
    return roundNumber;
  }

  public void setRoundNumber(Long roundNumber) {
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
