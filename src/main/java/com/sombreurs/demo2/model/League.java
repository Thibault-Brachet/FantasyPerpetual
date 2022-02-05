package com.sombreurs.demo2.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class League implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(name="league_name", nullable = false)
    private String leagueName;
    @Column(name="league_code", nullable = false)
    private String leagueCode;
    @Column(name = "league_current_pick")
    private Integer leagueCurrentPick;
    @Column(name = "picks_per_player")
    private Integer picksPerPlayer;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Player admin;
    @ManyToMany(mappedBy = "playedLeagues")
    Set<Account> accounts;

    public Player getAdmin() {
        return admin;
    }


    public League() {
    }

    public Integer getLeagueCurrentPick() {
        return leagueCurrentPick;
    }

    public void setLeagueCurrentPick(Integer leagueCurrentPick) {
        this.leagueCurrentPick = leagueCurrentPick;
    }

    public Integer getPicksPerPlayer() {
        return picksPerPlayer;
    }

    public void setPicksPerPlayer(Integer picksPerPlayer) {
        this.picksPerPlayer = picksPerPlayer;
    }

    public League(Long id, String leagueName, String leagueCode, Integer leagueCurrentPick, Integer picksPerPlayer, Player admin, Set<Account> accounts) {
        this.id = id;
        this.leagueName = leagueName;
        this.leagueCode = leagueCode;
        this.leagueCurrentPick = leagueCurrentPick;
        this.picksPerPlayer = picksPerPlayer;
        this.admin = admin;
        this.accounts = accounts;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueCode() {
        return leagueCode;
    }

    public void setLeagueCode(String leagueCode) {
        this.leagueCode = leagueCode;
    }

    public void setAdmin(Player admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof League)) return false;
        League league = (League) o;
        return getId().equals(league.getId()) && getLeagueName().equals(league.getLeagueName()) && getLeagueCode().equals(league.getLeagueCode()) && getAdmin().equals(league.getAdmin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLeagueName(), getLeagueCode(), getAdmin());
    }
}
