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

    private Date date;

    private String heure;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MatchDto(Match match) {
        this.id = match.getId();
        this.roster1 = match.getRoster1();
        this.roster2 = match.getRoster2();
        this.winner = match.getWinner();
        this.duration = match.getDuration();
        this.score = match.getScore();
        this.date = match.getDate();
        this.heure = match.getHeure();
        this.status = match.getStatus();
    }
}
