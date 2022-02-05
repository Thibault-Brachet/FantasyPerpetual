package com.sombreurs.demo2.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Points implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pick_id")
    private Pick pick;
    @Column(name = "points_scored")
    private Integer pointsScored;
    private String epreuve;


    public Points() {
    }

    public Points(Long id, Pick pick, Integer pointsScored, String epreuve) {
        this.id = id;
        this.pick = pick;
        this.pointsScored = pointsScored;
        this.epreuve = epreuve;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pick getPick() {
        return pick;
    }

    public void setPick(Pick pick) {
        this.pick = pick;
    }

    public Integer getPointsScored() {
        return pointsScored;
    }

    public void setPointsScored(Integer pointsScored) {
        this.pointsScored = pointsScored;
    }

    public String getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(String epreuve) {
        this.epreuve = epreuve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Points)) return false;
        Points points = (Points) o;
        return getId().equals(points.getId()) && getPick().equals(points.getPick()) && getPointsScored().equals(points.getPointsScored()) && Objects.equals(getEpreuve(), points.getEpreuve());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPick(), getPointsScored(), getEpreuve());
    }
}
