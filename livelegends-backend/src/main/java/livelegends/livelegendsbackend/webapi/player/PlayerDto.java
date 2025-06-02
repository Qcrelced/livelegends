package livelegends.livelegendsbackend.webapi.player;

import livelegends.livelegendsbackend.core.roster.Roster;

public class PlayerDto {

    private Long id;

    private String pseudo;

    private Roster roster;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }
}
