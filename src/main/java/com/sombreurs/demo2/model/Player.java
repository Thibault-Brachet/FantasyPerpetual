package com.sombreurs.demo2.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;
    @Column(nullable = false)
    private String username;
    @Column(name = "total_points")
    private Integer totalPoints;
    private Integer ranking;
    @Column(name = "draft_rank")
    private Integer draftRank;
    @Column(name = "is_active")
    private Boolean isActive=false;
    @Column(name = "player_current_pick")
    private Integer playerCurrentPick;

    public Player() {
    }

    public Integer getPlayerCurrentPick() {
        return playerCurrentPick;
    }

    public void setPlayerCurrentPick(Integer playerCurrentPick) {
        this.playerCurrentPick = playerCurrentPick;
    }

    public Player(Long id, Account account, League league, String username, Integer totalPoints, Integer ranking, Integer draftRank, Boolean isActive, Integer playerCurrentPick) {
        this.id = id;
        this.account = account;
        this.league = league;
        this.username = username;
        this.totalPoints = totalPoints;
        this.ranking = ranking;
        this.draftRank = draftRank;
        this.isActive = isActive;
        this.playerCurrentPick = playerCurrentPick;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getDraftRank() {
        return draftRank;
    }

    public void setDraftRank(Integer draftRank) {
        this.draftRank = draftRank;
    }

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

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
