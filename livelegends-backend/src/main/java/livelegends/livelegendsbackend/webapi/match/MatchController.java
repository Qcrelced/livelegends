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

    private final MatchRepository matchRepository;
    private final MatchService matchService;
    public MatchController(MatchRepository matchRepository, MatchService matchService) {
        this.matchRepository = matchRepository;
        this.matchService = matchService;
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

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match match) {
        Match updated = matchService.updateMatch(id, match);
        return ResponseEntity.ok(updated);
    }

}
