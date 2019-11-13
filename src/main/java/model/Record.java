package model;

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
}
