package livelegends.livelegendsbackend.core.roster;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import livelegends.livelegendsbackend.core.player.Player;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rosters")
public class Roster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String teamName;

    @OneToMany(mappedBy = "roster", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Player> players = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
