package livelegends.livelegendsbackend.core.match;

import livelegends.livelegendsbackend.webapi.webSocket.MatchWebSocketController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final MatchWebSocketController matchWebSocketController;

    @Autowired
    public MatchService(MatchRepository matchRepository, MatchWebSocketController matchWebSocketController) {
        this.matchRepository = matchRepository;
        this.matchWebSocketController = matchWebSocketController;
    }

    public Match createMatch(Match match) {
        Match savedMatch = matchRepository.save(match);
        matchWebSocketController.sendMatchUpdate(match);
        return savedMatch;
    }

    public Match updateMatch(Long id, Match updatedMatch) {
        return matchRepository.findById(id)
                .map(existingMatch -> {
                    // mise à jour...
                    Match saved = matchRepository.save(existingMatch);
                    matchWebSocketController.sendMatchUpdate(updatedMatch);
                    return saved;
                })
                .orElseThrow(() -> new RuntimeException("Match not found"));
    }
}
