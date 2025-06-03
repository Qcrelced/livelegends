package livelegends.livelegendsbackend.webapi.match;

import livelegends.livelegendsbackend.core.roster.Roster;

public class MatchDto {

    private Long id;

    private Roster roster1;

    private Roster roster2;

    private String winner;

    private String duration;

    private String score;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
