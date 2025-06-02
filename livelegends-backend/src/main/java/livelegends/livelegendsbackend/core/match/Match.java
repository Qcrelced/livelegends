package livelegends.livelegendsbackend.core.match;

import jakarta.persistence.*;
import livelegends.livelegendsbackend.core.roster.game.RosterGame;

@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roster_1_id")
    private RosterGame rosterGame1;

    @ManyToOne
    @JoinColumn(name = "roster_2_id")
    private RosterGame rosterGame2;

    private String winner;

    private String duration;

    private String score;

    public Match(Long id, RosterGame roster1, RosterGame roster2, String winner, String duration, String score) {
        this.id = id;
        this.rosterGame1 = roster1;
        this.rosterGame2 = roster2;
        this.winner = winner;
        this.duration = duration;
        this.score = score;
    }

    public Match(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RosterGame getRoster1() {
        return rosterGame1;
    }

    public void setRoster1(RosterGame rosterGame1) {
        this.rosterGame1 = rosterGame1;
    }

    public RosterGame getRoster2() {
        return rosterGame2;
    }

    public void setRoster2(RosterGame rosterGame2) {
        this.rosterGame2 = rosterGame2;
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
}
