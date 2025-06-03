package livelegends.livelegendsbackend.core.match;

import livelegends.livelegendsbackend.webapi.match.MatchDto;
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
        matchWebSocketController.broadcastMatchUpdate(new MatchDto(savedMatch));
        return savedMatch;
    }

    public  Match updateMatch(Long id, Match updatedData) {
        return matchRepository.findById(id)
                .map(existingMatch -> {
                    existingMatch.setRoster1(updatedData.getRoster1());
                    existingMatch.setRoster2(updatedData.getRoster2());
                    existingMatch.setWinner(updatedData.getWinner());
                    existingMatch.setDuration(updatedData.getDuration());
                    existingMatch.setScore(updatedData.getScore());
                    existingMatch.setStatus(updatedData.getStatus());
                    existingMatch.setDate(updatedData.getDate());
                    existingMatch.setHeure(updatedData.getHeure());

                    Match saved = matchRepository.save(existingMatch);

                    // Envoi via WebSocket
                    MatchDto dto = new MatchDto(saved);
                    matchWebSocketController.broadcastMatchUpdate(dto);

                    return saved;
                })
                .orElseThrow(() -> new RuntimeException("Match non trouvé avec id : " + id));
    }
}
