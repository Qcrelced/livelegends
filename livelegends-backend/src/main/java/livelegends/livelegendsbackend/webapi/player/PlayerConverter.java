package livelegends.livelegendsbackend.webapi.player;

import livelegends.livelegendsbackend.core.player.Player;

public class PlayerConverter {

    public static PlayerDto convertPlayerToDto(final Player player) {
        PlayerDto playerDto = null;
        if (player != null) {
            playerDto = new PlayerDto();
            playerDto.setId(player.getId());
            playerDto.setPseudo(player.getPseudo());
            playerDto.setRoster(player.getRoster());
        }
        return playerDto;
    }

}
