package livelegends.livelegendsbackend.webapi.webSocket;

import livelegends.livelegendsbackend.core.match.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static livelegends.livelegendsbackend.webapi.webSocket.WebSocketConfig.CHANNEL_NAME;

@Controller
@RequestMapping("/ws")
public class MatchWebSocketController {
    private final List<Match> matchs = new ArrayList<>();

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public MatchWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/matchs")
    public void receiveMatch(Match match) {
        matchs.add(match);
        messagingTemplate.convertAndSend(CHANNEL_NAME, match);
    }

}