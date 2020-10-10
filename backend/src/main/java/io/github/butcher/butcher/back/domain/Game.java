package io.github.butcher.butcher.back.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Game {

  @Id
  @GenericGenerator(name = "game_id_seq", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {
      @org.hibernate.annotations.Parameter(name = "sequence_name", value = "game_id_seq"),
      @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
  private Long id;

  private Timestamp startTime;
  private Timestamp endTime;

  @ManyToOne
  private Team team1;

  @ManyToOne
  private Team team2;

  @Column(name = "team1_score")
  private Long team1Score;

  @Column(name = "team2_score")
  private Long team2Score;

  @Column(name = "team1_zone")
  private Long team1Zone;

  @Column(name = "team2_zone")
  private Long team2Zone;

  private Long possessionTeamId;

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

  public Long getTeam1Score() {
    return team1Score;
  }

  public void setTeam1Score(Long team1Score) {
    this.team1Score = team1Score;
  }

  public Long getTeam2Score() {
    return team2Score;
  }

  public void setTeam2Score(Long team2Score) {
    this.team2Score = team2Score;
  }

  public Long getTeam1Zone() {
    return team1Zone;
  }

  public void setTeam1Zone(Long team1Zone) {
    this.team1Zone = team1Zone;
  }

  public Long getTeam2Zone() {
    return team2Zone;
  }

  public void setTeam2Zone(Long team2Zone) {
    this.team2Zone = team2Zone;
  }

  public Long getPossessionTeamId() {
    return possessionTeamId;
  }

  public void setPossessionTeamId(Long possessionTeamId) {
    this.possessionTeamId = possessionTeamId;
  }

  public Timestamp getRoundEndTime() {
    return roundEndTime;
  }

  public void setRoundEndTime(Timestamp roundEndTime) {
    this.roundEndTime = roundEndTime;
  }
}
