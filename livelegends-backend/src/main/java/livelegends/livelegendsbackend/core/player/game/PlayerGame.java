package livelegends.livelegendsbackend.core.player.game;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import livelegends.livelegendsbackend.core.player.Player;
import livelegends.livelegendsbackend.core.roster.Roster;

public class PlayerGame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Roster roster;

    private Player player;

    private int kill;

    private int death;

    private int assist;

    private int headshots;


}
