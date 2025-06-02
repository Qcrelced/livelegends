package livelegends.livelegendsbackend.webapi.match;

import livelegends.livelegendsbackend.core.match.Match;
import livelegends.livelegendsbackend.core.match.MatchRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "/matchs")
public class MatchController {

    private final MatchRepository matchRepository;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping("/matchs")
    public List<Match> getMatchs() {
        List<Match> matchs = matchRepository.findAll();
        return matchs;
    }

//    @GetMapping("/matchs/{id}")
//    public MatchDto getMatchsbyId(@PathVariable Long id) {
//        MatchDto match = matchService.getMatchById(id);
//        return match;
//    }

    @PostMapping("/matchs")
    public void createMatch(@RequestBody Match match) {

    }

}
