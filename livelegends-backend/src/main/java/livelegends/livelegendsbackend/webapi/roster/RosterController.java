package livelegends.livelegendsbackend.webapi.roster;

import livelegends.livelegendsbackend.core.roster.Roster;
import livelegends.livelegendsbackend.core.roster.RosterRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class RosterController {

    private RosterWebApiService rosterWebApiService;
    private RosterRepository rosterRepository;

    public RosterController(RosterWebApiService rosterWebApiService, RosterRepository rosterRepository) {
        this.rosterWebApiService = rosterWebApiService;
        this.rosterRepository = rosterRepository;
    }

    @GetMapping("/rosters")
    public List<RosterDto> getRosters() {
        List<RosterDto> rosters = rosterWebApiService.getAllRosters();
        return rosters;
    }

    @GetMapping("/roster/{id}")
    public RosterDto getPlayerById(@PathVariable Long id) {
        RosterDto roster = rosterWebApiService.getRosterById(id);
        return roster;
    }

    @PostMapping("/roster")
    public void updateRoster(@RequestBody Roster roster) {
        rosterRepository.save(roster);
    }

}
