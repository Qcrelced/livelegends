import { Component, OnInit } from '@angular/core';
import { MatchService } from '../services/match.service';
import { WebsocketService } from '../services/websocket.service';
import { Subscription } from 'rxjs';

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
  selector: 'app-match',
  standalone: false,
  templateUrl: './match.component.html',
  styleUrl: './match.component.css'
})


export class MatchComponent implements OnInit {
  matchs: Match[] = [];
  selectedMatch: Match | null = null;
  private matchSub: Subscription | undefined;

  constructor(private matchService: MatchService, private websocketService: WebsocketService) {}

  ngOnInit() {
    this.matchService.getMatchs().subscribe(data => {
      this.matchs = data;
    });
    this.websocketService.onMatchReceived().subscribe(match => {
    const [a, b] = match.score?.split('-').map((s: string) => parseInt(s.trim(), 10)) || [0, 0];
    const enriched = { ...match, edition: false, scoreA: a, scoreB: b };

    const index = this.matchs.findIndex(m => m.id === match.id);
    if (index !== -1) {
      this.matchs[index] = enriched; 
    } else {
      this.matchs.push(enriched);    
    }
    });
}
  

  ngOnDestroy(): void {
    this.matchSub?.unsubscribe();
    this.websocketService.disconnect();
  }

  openMatch(match: any) {
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

  protected readonly MatchService = MatchService;


}
