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
  teamName: Match;
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
  showAddModal = false;
  rosters: Roster[] = [];
  newMatch: any = {};

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
      this.rosters = [
        ...new Map(
          this.matchs.flatMap(m => [m.roster1, m.roster2]).map(r => [r.id, r])
        ).values()
      ];
    });
    this.websocketService.onMatchReceived().subscribe(match => {
    const [a, b] = match.score?.split('-').map((s: string) => parseInt(s.trim(), 10)) || [0, 0];
    const enriched = { ...match, edition: false, scoreA: a, scoreB: b };

    const index = this.matchs.findIndex(m => m.id === match.id);
    if (index !== -1) {
      this.matchs[index] = enriched; // ✅ remplace l’ancien match
    } else {
      this.matchs.push(enriched);    // ✅ ajoute seulement s’il n’existe pas
    }
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


  openAddModal() {
    this.newMatch = {};
    this.showAddModal = true;
  }

  closeAddModal() {
    this.showAddModal = false;
  }



  addMatch() {
    const matchToAdd = {
      roster1: this.newMatch.roster1?.id,
      roster2: this.newMatch.roster2?.id,
      date_match: this.newMatch.date_match,
      heure: this.newMatch.heure,
      status: 'Pas commencé',
      score: '0-0'
    };
    console.log(matchToAdd); // Vérifie le format avant l'envoi
    this.matchService.addMatch(matchToAdd).subscribe({
      next: (createdMatch) => {
        this.matchs.push({
          ...createdMatch,
          edition: false,
          scoreA: 0,
          scoreB: 0
        });
        this.closeAddModal();
      },
      error: () => {
        alert('Erreur lors de l\'ajout du match');
      }
    });
  }

}


