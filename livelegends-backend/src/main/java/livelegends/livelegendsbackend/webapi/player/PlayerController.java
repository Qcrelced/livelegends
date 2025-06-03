package livelegends.livelegendsbackend.webapi.player;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
