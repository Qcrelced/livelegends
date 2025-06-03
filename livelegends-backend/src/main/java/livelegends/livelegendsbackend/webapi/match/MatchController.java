package livelegends.livelegendsbackend.webapi.match;

import livelegends.livelegendsbackend.core.match.Match;
import livelegends.livelegendsbackend.core.match.MatchRepository;
import livelegends.livelegendsbackend.core.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "/matchs")
public class MatchController {

    private final MatchWebApiService matchWebApiService;
    private final MatchRepository matchRepository;

    public MatchController(MatchWebApiService matchWebApiService, MatchRepository matchRepository) {
        this.matchWebApiService = matchWebApiService;
        this.matchRepository = matchRepository;
    }



    @GetMapping("/matchs")
    public List<MatchDto> getMatchs() {
        List<MatchDto> matchs = matchWebApiService.getAllMatchs();
        return matchs;
    }

    @GetMapping("/match/{id}")
    public MatchDto getMatchsbyId(@PathVariable Long id) {
        MatchDto match = matchWebApiService.getMatchById(id);
        return match;
    }

    @PostMapping("/match")
    public void createMatch(@RequestBody Match match) {
        matchRepository.save(match);
    }

}
