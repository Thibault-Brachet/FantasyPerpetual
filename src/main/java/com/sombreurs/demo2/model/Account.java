package com.sombreurs.demo2.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "user_password", nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "account_league",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "league_id"))
    Set<League> playedLeagues;



    public Account() {
    }

    public Account(Long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Account(Long id, String firstName, String lastName, String email, String password, Set<League> playedLeagues) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.playedLeagues = playedLeagues;
    }

    public Set<League> getPlayedLeagues() {
        return playedLeagues;
    }

    public void setPlayedLeagues(Set<League> playedLeagues) {
        this.playedLeagues = playedLeagues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
