package livelegends.livelegendsbackend.webapi.match;

import livelegends.livelegendsbackend.core.match.Match;
import livelegends.livelegendsbackend.core.roster.Roster;

import java.util.Date;

public class MatchDto {

    private Long id;

    private Roster roster1;

    private Roster roster2;

    private String winner;

    private String duration;

    private String score;

    private String status;

    private Date date_match;

    private String heure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roster getRoster1() {
        return roster1;
    }

    public void setRoster1(Roster roster1) {
        this.roster1 = roster1;
    }

    public Roster getRoster2() {
        return roster2;
    }

    public void setRoster2(Roster roster2) {
        this.roster2 = roster2;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate_match() {
        return date_match;
    }

    public void setDate_match(Date date_match) {
        this.date_match = date_match;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
  
}
