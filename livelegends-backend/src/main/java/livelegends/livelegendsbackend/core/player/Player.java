package livelegends.livelegendsbackend.core.player;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import livelegends.livelegendsbackend.core.roster.Roster;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pseudo;

    public Player(Long id, String pseudo, Roster roster) {
        this.id = id;
        this.pseudo = pseudo;
        this.roster = roster;
    }

    @ManyToOne
    @JoinColumn(name = "roster_id")
    @JsonBackReference
    private Roster roster;

    public Player() {
    }

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
