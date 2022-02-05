package com.sombreurs.demo2.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "scoring_system")
public class ScoringSystem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "first_place_final_winner")
    private Integer firstPlace;
    @Column(name = "second_place_final_loser")
    private Integer secondPlacee;
    @Column(name = "third_place_semi_final")
    private Integer thirdPlace;
    @Column(name = "fourth_place_quarter_final")
    private Integer fourthPlace;
    @Column(name = "fifth_place")
    private Integer fifthPlace;
    @Column(name = "sixth_place")
    private Integer sixthPlace;



    public ScoringSystem() {
    }


    public ScoringSystem(Long id, String name, Integer firstPlace, Integer secondPlacee, Integer thirdPlace, Integer fourthPlace, Integer fifthPlace, Integer sixthPlace) {
        this.id = id;
        this.name = name;
        this.firstPlace = firstPlace;
        this.secondPlacee = secondPlacee;
        this.thirdPlace = thirdPlace;
        this.fourthPlace = fourthPlace;
        this.fifthPlace = fifthPlace;
        this.sixthPlace = sixthPlace;
    }

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

    public Integer getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(Integer firstPlace) {
        this.firstPlace = firstPlace;
    }

    public Integer getSecondPlacee() {
        return secondPlacee;
    }

    public void setSecondPlacee(Integer secondPlacee) {
        this.secondPlacee = secondPlacee;
    }

    public Integer getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(Integer thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    public Integer getFourthPlace() {
        return fourthPlace;
    }

    public void setFourthPlace(Integer fourthPlace) {
        this.fourthPlace = fourthPlace;
    }

    public Integer getFifthPlace() {
        return fifthPlace;
    }

    public void setFifthPlace(Integer fifthPlace) {
        this.fifthPlace = fifthPlace;
    }

    public Integer getSixthPlace() {
        return sixthPlace;
    }

    public void setSixthPlace(Integer sixthPlace) {
        this.sixthPlace = sixthPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScoringSystem)) return false;
        ScoringSystem that = (ScoringSystem) o;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && Objects.equals(getFirstPlace(), that.getFirstPlace()) && Objects.equals(getSecondPlacee(), that.getSecondPlacee()) && Objects.equals(getThirdPlace(), that.getThirdPlace()) && Objects.equals(getFourthPlace(), that.getFourthPlace()) && Objects.equals(getFifthPlace(), that.getFifthPlace()) && Objects.equals(getSixthPlace(), that.getSixthPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFirstPlace(), getSecondPlacee(), getThirdPlace(), getFourthPlace(), getFifthPlace(), getSixthPlace());
    }
}
