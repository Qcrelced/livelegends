package livelegends.livelegendsbackend.webapi.common.match;

import livelegends.livelegendsbackend.core.match.Match;
import livelegends.livelegendsbackend.core.match.MatchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping( "/matchs")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

//    @GetMapping("/matchs")
//    public List<MatchDto> getMatchs() {
//        List<MatchDto> matchs = matchService.getAllMatchs();
//        return matchs;
//    }
//
//    @GetMapping("/matchs/{id}")
//    public MatchDto getMatchsbyId(@PathVariable Long id) {
//        MatchDto match = matchService.getMatchById(id);
//        return match;
//    }

    @PostMapping("/matchs")
    public void createMatch(@RequestBody Match match) {

    }

}
