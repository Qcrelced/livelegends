package livelegends.livelegendsbackend.webapi.roster;

import livelegends.livelegendsbackend.core.roster.Roster;

public class RosterConverter {

    public static RosterDto convertRosterToDto(final Roster roster) {
        RosterDto rosterDto = null;
        if (roster != null) {
            rosterDto = new RosterDto();
            rosterDto.setId(roster.getId());
            rosterDto.setPlayers(roster.getPlayers());
            rosterDto.setName(roster.getTeamName());
        }
        return rosterDto;
    }

}
