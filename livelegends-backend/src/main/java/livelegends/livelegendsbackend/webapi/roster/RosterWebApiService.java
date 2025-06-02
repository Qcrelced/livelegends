package livelegends.livelegendsbackend.webapi.roster;

import livelegends.livelegendsbackend.core.roster.Roster;
import livelegends.livelegendsbackend.core.roster.RosterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RosterWebApiService {

    private final RosterRepository rosterRepository;

    public RosterWebApiService(RosterRepository rosterRepository) {
        this.rosterRepository = rosterRepository;
    }

    public List<RosterDto> getAllRosters() {
        List<RosterDto> rostersToSend = new ArrayList<>();
        List<Roster> rosters = rosterRepository.findAll();
        for (Roster roster : rosters) {
            RosterDto rosterDto = RosterConverter.convertRosterToDto(roster);
            rostersToSend.add(rosterDto);
        }
        return rostersToSend;
    }

    public RosterDto getRosterById(Long id) {
        Roster roster = rosterRepository.findById(id).orElse(null);
        RosterDto rosterDto = RosterConverter.convertRosterToDto(roster);
        return rosterDto;
    }

}
