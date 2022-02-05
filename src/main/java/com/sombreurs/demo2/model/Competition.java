package com.sombreurs.demo2.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Competition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;
    @ManyToOne
    @JoinColumn(name = "scoring_system_id")
    private ScoringSystem scoringSystem;
    private String name;
    private String url;
    private Integer malus;
    @Column(name = "malus_progressif")
    private Boolean malusProgressif;
    @Column(name = "bonus_france")
    private Boolean bonusFrance;
    @Column(name = "starting_date")
    private Date startingDate;
    @Column(name = "end_date")
    private Date endDate;
    private Date deadline;
    @Column(name = "max_picks")
    private Integer maxPicks;
    @Column(name = "competition_current_pick")
    private Integer competitionCurrentPick;


    public Competition() {
    }

    public Integer getCompetitionCurrentPick() {
        return competitionCurrentPick;
    }

    public void setCompetitionCurrentPick(Integer competitionCurrentPick) {
        this.competitionCurrentPick = competitionCurrentPick;
    }

    public Competition(Long id, League league, ScoringSystem scoringSystem, String name, String url, Integer malus, Boolean malusProgressif, Boolean bonusFrance, Date startingDate, Date endDate, Date deadline, Integer maxPicks, Integer competitionCurrentPick) {
        this.id = id;
        this.league = league;
        this.scoringSystem = scoringSystem;
        this.name = name;
        this.url = url;
        this.malus = malus;
        this.malusProgressif = malusProgressif;
        this.bonusFrance = bonusFrance;
        this.startingDate = startingDate;
        this.endDate = endDate;
        this.deadline = deadline;
        this.maxPicks = maxPicks;
        this.competitionCurrentPick = competitionCurrentPick;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public ScoringSystem getScoringSystem() {
        return scoringSystem;
    }

    public void setScoringSystem(ScoringSystem scoringSystem) {
        this.scoringSystem = scoringSystem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMalus() {
        return malus;
    }

    public void setMalus(Integer malus) {
        this.malus = malus;
    }

    public Boolean getMalusProgressif() {
        return malusProgressif;
    }

    public void setMalusProgressif(Boolean malusProgressif) {
        this.malusProgressif = malusProgressif;
    }

    public Boolean getBonusFrance() {
        return bonusFrance;
    }

    public void setBonusFrance(Boolean bonusFrance) {
        this.bonusFrance = bonusFrance;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getMaxPicks() {
        return maxPicks;
    }

    public void setMaxPicks(Integer maxPicks) {
        this.maxPicks = maxPicks;
    }
}
