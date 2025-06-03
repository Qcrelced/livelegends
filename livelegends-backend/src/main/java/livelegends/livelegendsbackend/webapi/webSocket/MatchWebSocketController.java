package livelegends.livelegendsbackend.webapi.webSocket;

import livelegends.livelegendsbackend.core.match.Match;
import livelegends.livelegendsbackend.webapi.match.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/matchs")
public class MatchWebSocketController {
    private final List<Match> matchs = new ArrayList<>();

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public MatchWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping
    public void receiveMatch(Match match) {
        matchs.add(match);
        messagingTemplate.convertAndSend("/matchs", match);
    }

}