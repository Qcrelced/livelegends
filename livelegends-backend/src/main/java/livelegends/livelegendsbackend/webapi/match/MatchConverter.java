package livelegends.livelegendsbackend.webapi.match;

import livelegends.livelegendsbackend.core.match.Match;

public class MatchConverter {

    private MatchConverter(){
    };

    public static MatchDto convertMatchToDto(final Match match) {
        MatchDto matchDto = null;
        if (matchDto != null) {
            matchDto = new MatchDto();
            matchDto.setId(match.getId());
            matchDto.setRoster1(match.getRoster1());
            matchDto.setRoster2(match.getRoster2());
            matchDto.setWinner(match.getWinner());
            matchDto.setDuration(match.getDuration());
            matchDto.setScore(match.getScore());
            matchDto.setStatus(match.getStatus());
            matchDto.setDate(match.getDate());
            matchDto.setHeure(match.getHeure());
        }
        return matchDto;
    }
}
