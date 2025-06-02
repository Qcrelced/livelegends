package livelegends.livelegendsbackend.core.player;

import livelegends.livelegendsbackend.webapi.player.PlayerConverter;
import livelegends.livelegendsbackend.webapi.player.PlayerDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository adminRepository) {
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
