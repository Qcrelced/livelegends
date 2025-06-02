package livelegends.livelegendsbackend.webapi.roster;

import livelegends.livelegendsbackend.core.player.Player;

import java.util.ArrayList;
import java.util.List;

public class RosterDto {

    private Long id;

    private String name;

    private List<Player> players = new ArrayList<>();

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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
