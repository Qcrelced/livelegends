package livelegends.livelegendsbackend.core.roster.game;

import jakarta.persistence.*;
import livelegends.livelegendsbackend.core.player.game.PlayerGame;
import livelegends.livelegendsbackend.core.roster.Roster;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rosters_game")
public class RosterGame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roster_id")
    private Roster roster;

    private List<PlayerGame> playersGame = new ArrayList<>();

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PlayerGame> getPlayers() {
        return playersGame;
    }

    public void setPlayers(List<PlayerGame> playersGame) {
        this.playersGame = playersGame;
    }
}
