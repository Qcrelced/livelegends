package livelegends.livelegendsbackend.webapi.player;

import livelegends.livelegendsbackend.core.player.Player;
import livelegends.livelegendsbackend.core.player.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerWebApiService playerWebApiService;
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerWebApiService playerWebApiService, PlayerRepository playerRepository) {
        this.playerWebApiService = playerWebApiService;
        this.playerRepository = playerRepository;
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

    @PostMapping("/player")
    public void updatePlayer(@RequestBody Player player) {
        playerRepository.save(player);
    }

}
