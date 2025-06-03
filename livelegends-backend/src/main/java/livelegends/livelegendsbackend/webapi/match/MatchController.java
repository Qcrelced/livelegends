package livelegends.livelegendsbackend.webapi.match;

import livelegends.livelegendsbackend.core.match.*;
import livelegends.livelegendsbackend.core.roster.*;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/matchs")
public class MatchController {

    private final MatchWebApiService matchWebApiService;
    private final MatchRepository matchRepository;
    private final RosterRepository rosterRepository;

    public MatchController(MatchWebApiService matchWebApiService, MatchRepository matchRepository, RosterRepository rosterRepository) {
        this.matchWebApiService = matchWebApiService;
        this.matchRepository = matchRepository;
        this.rosterRepository = rosterRepository;
    }

    @GetMapping("/matchs")
    public List<MatchDto> getMatchs() {
        return matchWebApiService.getAllMatchs();
    }

    @GetMapping("/match/{id}")
    public MatchDto getMatchsbyId(@PathVariable Long id) {
        return matchWebApiService.getMatchById(id);
    }

    @PostMapping("/matchs")
    public MatchDto createMatch(@RequestBody MatchCreateDto dto) {
        Roster roster1 = rosterRepository.findById(dto.roster1).orElseThrow();
        Roster roster2 = rosterRepository.findById(dto.roster2).orElseThrow();
        Date dateMatch = java.sql.Date.valueOf(dto.date_match); // si dto.date_match est au format "yyyy-MM-dd"
        Match match = new Match(null, roster1, roster2, dto.winner, dto.duration, dto.score, dto.status, dateMatch, dto.heure);
        Match savedMatch = matchRepository.save(match);
        return MatchConverter.convertMatchToDto(savedMatch);
    }

    @PutMapping("/matchs/{id}")
    public MatchDto updateMatch(@PathVariable Long id, @RequestBody Match match) {
        match.setId(id);
        Match updatedMatch = matchRepository.save(match);
        return MatchConverter.convertMatchToDto(updatedMatch);
    }
}