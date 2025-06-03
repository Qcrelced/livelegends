import { Component, OnInit } from '@angular/core';
import { MatchService } from '../services/match.service';

interface Match {
  id: number;
  roster1: Roster;
  roster2: Roster;
  winner: string;
  duration: string;
  score: string;
  status: string;
  date_match: string;
  heure: string;
}

interface Roster {
  id: number;
  teamName: string;
  players: any[];
}

@Component({
  selector: 'app-accueil',
  standalone: false,
  templateUrl: './accueil.component.html',
  styleUrl: './accueil.component.css'
})
export class AccueilComponent implements OnInit {
  matchs: Match[] = [];
  teams: any[] = [];
  selectedMatch: Match | null = null;

  constructor(private matchService: MatchService) {}

  ngOnInit() {
    this.matchService.getMatchs().subscribe(data => {
      this.matchs = data;
      this.teams = this.extractTeamsFromMatchs(this.matchs);
    });
  }

  extractTeamsFromMatchs(matchs: Match[]): any[] {
    const teamMap = new Map<number, any>();
    matchs.forEach(match => {
      [match.roster1, match.roster2].forEach(roster => {
        if (!teamMap.has(roster.id)) {
          teamMap.set(roster.id, {
            id: roster.id,
            name: roster.teamName,
            logo: `https://picsum.photos/180/180?random=${roster.id}`,
            players: roster.players,
            // Ajoute ici d'autres stats si tu les as en BDD
          });
        }
      });
    });
    return Array.from(teamMap.values());
  }

  getNextMatchesForTeam(teamId: number, count: number = 2) {
    return this.autresMatchs
      .filter(m => m.roster1.id === teamId || m.roster2.id === teamId)
      .slice(0, count);
  }

  openMatch(match: Match) {
    this.selectedMatch = match;
  }

  closeModal() {
    this.selectedMatch = null;
  }

  get matchsEnCours() {
    return this.matchs.filter(match => match.status === 'En cours');
  }
  get matchsFinis() {
    return this.matchs.filter(match => match.status === 'Fini');
  }
  get autresMatchs() {
    return this.matchs.filter(match => match.status === 'Pas commencé');
  }

}


