package io.github.butcher.butcher.back.domain;

import org.hibernate.annotations.GenericGenerator;

import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
public class Player {
    @Id
    @GenericGenerator(name = "player_id_seq", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@Parameter(name = "sequence_name", value = "player_id_seq"), @Parameter(name = "increment_size", value = "1")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_id_seq")
    private Long id;

    private String username;

    private String uid;

    @ManyToOne
    private Team team_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Team getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Team team_id) {
        this.team_id = team_id;
    }
}
