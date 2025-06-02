package livelegends.livelegendsbackend.webapi.player;

import livelegends.livelegendsbackend.core.player.Player;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerWebApiService playerWebApiService;

    public PlayerController(PlayerWebApiService playerWebApiService) {
        this.playerWebApiService = playerWebApiService;
    }

    @GetMapping("/players")
    public List<PlayerDto> getPlayers() {
        List<PlayerDto> players = playerWebApiService.getAllPlayers();
        return players;
    }

    @GetMapping("/player/{id}")
    public PlayerDto getPlayerById(@PathVariable Long id) {
        PlayerDto player = playerWebApiService.getPlayerById(id);
        return player;
    }

}
