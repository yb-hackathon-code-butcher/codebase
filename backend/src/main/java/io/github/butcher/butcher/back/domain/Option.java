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

    private Integer duel_def;

    private Integer pass_def;

    private Integer shoot_def;

    private Integer risk;

    private String win;

    private Integer win_chance;

    private String loss;

    private Integer loss_chance;

    private Integer card_risk;

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

    public Integer getDuel_def() {
        return duel_def;
    }

    public void setDuel_def(Integer duel_def) {
        this.duel_def = duel_def;
    }

    public Integer getPass_def() {
        return pass_def;
    }

    public void setPass_def(Integer pass_def) {
        this.pass_def = pass_def;
    }

    public Integer getShoot_def() {
        return shoot_def;
    }

    public void setShoot_def(Integer shoot_def) {
        this.shoot_def = shoot_def;
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

    public Integer getWin_chance() {
        return win_chance;
    }

    public void setWin_chance(Integer win_chance) {
        this.win_chance = win_chance;
    }

    public String getLoss() {
        return loss;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }

    public Integer getLoss_chance() {
        return loss_chance;
    }

    public void setLoss_chance(Integer loss_chance) {
        this.loss_chance = loss_chance;
    }

    public Integer getCard_risk() {
        return card_risk;
    }

    public void setCard_risk(Integer card_risk) {
        this.card_risk = card_risk;
    }
}
