package livelegends.livelegendsbackend.webapi.webSocket;

import livelegends.livelegendsbackend.core.match.Match;
import livelegends.livelegendsbackend.webapi.match.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MatchWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public MatchWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void broadcastMatchUpdate(MatchDto matchDto) {
        messagingTemplate.convertAndSend("/matchs/updates", matchDto);
    }
}