package com.sombreurs.demo2.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Pick implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;
    private String name;
    @Column(name = "league_pick_number")
    private Integer leaguePickNumber;
    @Column(name = "player_pick_number")
    private Integer playerPickNumber;
    @Column(name = "competition_pick_number")
    private Integer competitionPickNumber;
    @Column(name = "bonus_pick")
    private Boolean bonusPick;


    public Pick() {
    }

    public Pick(Long id, Player player, Competition competition, String name, Integer leaguePickNumber, Integer playerPickNumber, Integer competitionPickNumber, Boolean bonusPick) {
        this.id = id;
        this.player = player;
        this.competition = competition;
        this.name = name;
        this.leaguePickNumber = leaguePickNumber;
        this.playerPickNumber = playerPickNumber;
        this.competitionPickNumber = competitionPickNumber;
        this.bonusPick = bonusPick;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLeaguePickNumber() {
        return leaguePickNumber;
    }

    public void setLeaguePickNumber(Integer leaguePickNumber) {
        this.leaguePickNumber = leaguePickNumber;
    }

    public Integer getPlayerPickNumber() {
        return playerPickNumber;
    }

    public void setPlayerPickNumber(Integer playerPickNumber) {
        this.playerPickNumber = playerPickNumber;
    }

    public Integer getCompetitionPickNumber() {
        return competitionPickNumber;
    }

    public void setCompetitionPickNumber(Integer competitionPickNumber) {
        this.competitionPickNumber = competitionPickNumber;
    }

    public Boolean getBonusPick() {
        return bonusPick;
    }

    public void setBonusPick(Boolean bonusPick) {
        this.bonusPick = bonusPick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pick)) return false;
        Pick pick = (Pick) o;
        return getId().equals(pick.getId()) && getPlayer().equals(pick.getPlayer()) && getCompetition().equals(pick.getCompetition()) && getName().equals(pick.getName()) && Objects.equals(getLeaguePickNumber(), pick.getLeaguePickNumber()) && Objects.equals(getPlayerPickNumber(), pick.getPlayerPickNumber()) && Objects.equals(getCompetitionPickNumber(), pick.getCompetitionPickNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPlayer(), getCompetition(), getName(), getLeaguePickNumber(), getPlayerPickNumber(), getCompetitionPickNumber());
    }
}
