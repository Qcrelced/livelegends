package livelegends.livelegendsbackend.webapi.webSocket;

import livelegends.livelegendsbackend.core.match.Match;
import livelegends.livelegendsbackend.webapi.common.match.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MatchWebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendMatchUpdate(Match match) {
        MatchDto msg = new MatchDto();
        msg.setId(match.getId());
        msg.setRoster1(msg.getRoster1());
        msg.setRoster2(msg.getRoster2());
        msg.setDuration(match.getDuration());
        msg.setScore(match.getScore());
        msg.setWinner(match.getWinner());

        messagingTemplate.convertAndSend("/matches", msg);
    }
}