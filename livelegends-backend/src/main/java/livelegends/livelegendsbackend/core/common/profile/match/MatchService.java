package livelegends.livelegendsbackend.core.common.profile.match;

import livelegends.livelegendsbackend.core.roster.Roster;
import livelegends.livelegendsbackend.core.roster.RosterRepository;
import livelegends.livelegendsbackend.webapi.common.match.MatchConverter;
import livelegends.livelegendsbackend.webapi.common.match.MatchDto;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final RosterRepository rosterRepository;

    public MatchService(MatchRepository matchRepository, RosterRepository rosterRepository) {
        this.matchRepository = matchRepository;
        this.rosterRepository = rosterRepository;
    }

    public List<MatchDto> getAllMatchs() {
        List<MatchDto> matchToSend = new ArrayList<>();
        List<Match> matchs = matchRepository.findAll();
        for (Match match : matchs) {
            MatchDto matchDto = MatchConverter.convertMatchToDto(match);
            matchToSend.add(matchDto);
        }
        return matchToSend;
    }

    public MatchDto getMatchById(Long id) {
        Match match = matchRepository.findById(id).orElse(null);
        MatchDto matchDto = MatchConverter.convertMatchToDto(match);
        return matchDto;
    }


}
