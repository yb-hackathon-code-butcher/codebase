package io.github.butcher.butcher.back.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Option {

  @Id
  @GenericGenerator(name = "option_id_seq", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {
      @org.hibernate.annotations.Parameter(name = "sequence_name", value = "option_id_seq"),
      @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "option_id_seq")
  private Long id;

  private String name;
  private Boolean possession;
  private Long zone;
  private String category;
  private Long duel;
  private Long pass;
  private Long shoot;
  private Long duelDef;
  private Long passDef;
  private Long shootDef;
  private Long risk;
  private String win;
  private Long winChance;
  private String loss;
  private Long lossChance;
  private Long cardRisk;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getPossession() {
    return possession;
  }

  public void setPossession(Boolean possession) {
    this.possession = possession;
  }

  public Long getZone() {
    return zone;
  }

  public void setZone(Long zone) {
    this.zone = zone;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Long getDuel() {
    return duel;
  }

  public void setDuel(Long duel) {
    this.duel = duel;
  }

  public Long getPass() {
    return pass;
  }

  public void setPass(Long pass) {
    this.pass = pass;
  }

  public Long getShoot() {
    return shoot;
  }

  public void setShoot(Long shoot) {
    this.shoot = shoot;
  }

  public Long getDuelDef() {
    return duelDef;
  }

  public void setDuelDef(Long duelDef) {
    this.duelDef = duelDef;
  }

  public Long getPassDef() {
    return passDef;
  }

  public void setPassDef(Long passDef) {
    this.passDef = passDef;
  }

  public Long getShootDef() {
    return shootDef;
  }

  public void setShootDef(Long shootDef) {
    this.shootDef = shootDef;
  }

  public Long getRisk() {
    return risk;
  }

  public void setRisk(Long risk) {
    this.risk = risk;
  }

  public String getWin() {
    return win;
  }

  public void setWin(String win) {
    this.win = win;
  }

  public Long getWinChance() {
    return winChance;
  }

  public void setWinChance(Long winChance) {
    this.winChance = winChance;
  }

  public String getLoss() {
    return loss;
  }

  public void setLoss(String loss) {
    this.loss = loss;
  }

  public Long getLossChance() {
    return lossChance;
  }

  public void setLossChance(Long lossChance) {
    this.lossChance = lossChance;
  }

  public Long getCardRisk() {
    return cardRisk;
  }

  public void setCardRisk(Long cardRisk) {
    this.cardRisk = cardRisk;
  }
}
