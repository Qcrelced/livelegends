package livelegends.livelegendsbackend.webapi.match;

import livelegends.livelegendsbackend.core.match.Match;
import livelegends.livelegendsbackend.core.match.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchWebApiService {

    private final MatchRepository matchRepository;

    public MatchWebApiService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<MatchDto> getAllMatchs() {
        List<MatchDto> matchsToSend = new ArrayList<>();
        List<Match> matchs = matchRepository.findAll();
        for (Match match : matchs) {
            MatchDto matchDto = MatchConverter.convertMatchToDto(match);
            matchsToSend.add(matchDto);
        }
        return matchsToSend;
    }

    public MatchDto getMatchById(Long id) {
        Match match = matchRepository.findById(id).orElse(null);
        MatchDto matchDto = MatchConverter.convertMatchToDto(match);
        return matchDto;
    }

}
