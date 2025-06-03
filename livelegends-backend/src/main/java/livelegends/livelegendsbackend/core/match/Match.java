package livelegends.livelegendsbackend.core.match;

import jakarta.persistence.*;
import livelegends.livelegendsbackend.core.roster.Roster;

import java.util.Date;

@Entity
@Table(name = "matchs")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roster_1_id")
    private Roster roster1;

    @ManyToOne
    @JoinColumn(name = "roster_2_id")
    private Roster roster2;

    private String winner;

    private String duration;

    private String score;

    private String status;

    private Date date;

    private String heure;

    public Match(Long id, Roster roster1, Roster roster2, String winner, String duration, String score, String status, Date date, String heure) {
        this.id = id;
        this.roster1 = roster1;
        this.roster2 = roster2;
        this.winner = winner;
        this.duration = duration;
        this.score = score;
        this.status = status;
        this.date = date;
        this.heure = heure;
    }

    public Match(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Roster getRoster2() {
        return roster2;
    }

    public void setRoster2(Roster roster2) {
        this.roster2 = roster2;
    }

    public Roster getRoster1() {
        return roster1;
    }

    public void setRoster1(Roster roster1) {
        this.roster1 = roster1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
