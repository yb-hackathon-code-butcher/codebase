package io.github.butcher.butcher.back.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Option {
    @Id
    @GenericGenerator(name = "option_id_seq", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@org.hibernate.annotations.Parameter(name = "sequence_name", value = "option_id_seq"), @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "option_id_seq")
    private Long id;

    private String name;

    private Boolean possession;

    private Integer zone;

    private String category;

    private Integer duel;

    private Integer pass;

    private Integer shoot;

    private Integer duelDef;

    private Integer passDef;

    private Integer shootDef;

    private Integer risk;

    private String win;

    private Integer winChance;

    private String loss;

    private Integer lossChance;

    private Integer cardRisk;

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

    public Integer getZone() {
        return zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getDuel() {
        return duel;
    }

    public void setDuel(Integer duel) {
        this.duel = duel;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getShoot() {
        return shoot;
    }

    public void setShoot(Integer shoot) {
        this.shoot = shoot;
    }

    public Integer getDuelDef() {
        return duelDef;
    }

    public void setDuelDef(Integer duelDef) {
        this.duelDef = duelDef;
    }

    public Integer getPassDef() {
        return passDef;
    }

    public void setPassDef(Integer passDef) {
        this.passDef = passDef;
    }

    public Integer getShootDef() {
        return shootDef;
    }

    public void setShootDef(Integer shootDef) {
        this.shootDef = shootDef;
    }

    public Integer getRisk() {
        return risk;
    }

    public void setRisk(Integer risk) {
        this.risk = risk;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public Integer getWinChance() {
        return winChance;
    }

    public void setWinChance(Integer winChance) {
        this.winChance = winChance;
    }

    public String getLoss() {
        return loss;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }

    public Integer getLossChance() {
        return lossChance;
    }

    public void setLossChance(Integer lossChance) {
        this.lossChance = lossChance;
    }

    public Integer getCardRisk() {
        return cardRisk;
    }

    public void setCardRisk(Integer cardRisk) {
        this.cardRisk = cardRisk;
    }
}
