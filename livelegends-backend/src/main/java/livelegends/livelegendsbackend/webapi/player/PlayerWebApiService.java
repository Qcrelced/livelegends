package livelegends.livelegendsbackend.webapi.player;

import livelegends.livelegendsbackend.core.player.Player;
import livelegends.livelegendsbackend.core.player.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerWebApiService {

    private final PlayerRepository playerRepository;

    public PlayerWebApiService(PlayerRepository adminRepository) {
        this.playerRepository = adminRepository;
    }

    public List<PlayerDto> getAllPlayers() {
        List<PlayerDto> playersToSend = new ArrayList<>();
        List<Player> players = playerRepository.findAll();
        for (Player player : players) {
            PlayerDto playerDto = PlayerConverter.convertPlayerToDto(player);
            playersToSend.add(playerDto);
        }
        return playersToSend;
    }

    public PlayerDto getPlayerById(Long id) {
        Player player = playerRepository.findById(id).orElse(null);
        PlayerDto playerDto = PlayerConverter.convertPlayerToDto(player);
        return playerDto;
    }

}
