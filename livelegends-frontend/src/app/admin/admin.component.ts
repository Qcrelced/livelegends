import { Component, OnInit } from '@angular/core';
import { MatchService } from '../services/match.service';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {WebsocketService} from '../services/websocket.service';

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
  edition?: boolean;
  scoreA?: number;
  scoreB?: number;
}

interface Roster {
  id: number;
  teamName: string;
  players: any[];
}

@Component({
  selector: 'app-admin',
  standalone: false,
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  matchs: Match[] = [];
  etats = ['Pas commencé', 'En cours', 'Fini'];

  constructor(private matchService: MatchService, private websocketService: WebsocketService) {}

  ngOnInit() {
    this.matchService.getMatchs().subscribe(data => {
      this.matchs = data.map(m => {
        let scoreA, scoreB;
        if (m.score && m.score.includes('-')) {
          const [a, b] = m.score.split('-').map((s: string) => parseInt(s.trim(), 10));
          scoreA = a;
          scoreB = b;
        }
        return { ...m, edition: false, scoreA, scoreB };
      });
    });
   
  }

  editMatch(match: Match) {
    match.edition = true;
  }

  saveMatch(match: Match) {
    match.score = `${match.scoreA ?? 0}-${match.scoreB ?? 0}`;
    match.edition = false;
    this.matchService.updateMatch(match).subscribe({
      next: () => {
        this.websocketService.sendMatch(match);
      },
      error: (err) => {
        alert('Erreur lors de la sauvegarde');
      }
    });
  }

  cancelEdit(match: Match) {
    if (match.score && match.score.includes('-')) {
      const [a, b] = match.score.split('-').map(s => parseInt(s.trim(), 10));
      match.scoreA = a;
      match.scoreB = b;
    }
    match.edition = false;
  }
}
