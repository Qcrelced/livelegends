package livelegends.livelegendsbackend.webapi.common.match;

import livelegends.livelegendsbackend.core.common.profile.admin.Admin;
import livelegends.livelegendsbackend.core.common.profile.admin.AdminService;
import livelegends.livelegendsbackend.core.common.profile.match.Match;
import livelegends.livelegendsbackend.core.common.profile.match.MatchService;
import livelegends.livelegendsbackend.webapi.common.profile.admin.AdminDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "/matchs")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/matchs")
    public List<MatchDto> getMatchs() {
        List<MatchDto> matchs = matchService.getAllMatchs();
        return matchs;
    }

    @GetMapping("/matchs/{id}")
    public MatchDto getMatchsbyId(@PathVariable Long id) {
        MatchDto match = matchService.getMatchById(id);
        return match;
    }

    @PostMapping("/matchs")
    public void createMatch(@RequestBody Match match) {

    }

}
