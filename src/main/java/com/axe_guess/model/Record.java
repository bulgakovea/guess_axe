package com.axe_guess.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table
public class Record {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private int score;

    @Column
    private int numberOfTry;

    @Column
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }

    public void setNumberOfTry(int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }
}
