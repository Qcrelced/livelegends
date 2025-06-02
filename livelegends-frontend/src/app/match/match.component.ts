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
}

interface Roster {
  id: number;
  teamName: string;
  players: any[];
}

@Component({
  selector: 'app-match',
  standalone: false,
  templateUrl: './match.component.html',
  styleUrl: './match.component.css'
})


export class MatchComponent implements OnInit {
  matchs: Match[] = [];
  selectedMatch: Match | null = null;
   // Assurez-vous que l'URL correspond à votre API

  constructor(private matchService: MatchService) {}

  ngOnInit() {
    this.matchService.getMatchs().subscribe(data => {
      // Adapter si besoin pour correspondre à la structure attendue
      this.matchs = data;
    });
  }

  openMatch(match: any) {
    this.selectedMatch = match;
  }

  closeModal() {
    this.selectedMatch = null;
  }

  get matchsEnCours() {
    return this.matchs.filter(match => match.status);
  }
  get matchsFinis() {
    return this.matchs.filter(match => match.status );
  }
  get autresMatchs() {
    return this.matchs.filter(match => !match.status);
  }

  protected readonly MatchService = MatchService;
}
