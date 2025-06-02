import { Component } from '@angular/core';

@Component({
  selector: 'app-match',
  standalone: false,
  templateUrl: './match.component.html',
  styleUrl: './match.component.css'
})
export class MatchComponent {
  matchs = [
    { equipe1: 'Team Alpha', equipe2: 'Team Beta', date: new Date(2025, 5, 2), heure: '20h00', jeu: 'CS2', image: 'https://picsum.photos/400/200?random=10', score: '1 - 2', enCours: true },
    { equipe1: 'Squad X', equipe2: 'Warriors', date: new Date(2025, 5, 3), heure: '18h30', jeu: 'CS2', image: 'https://picsum.photos/400/200?random=11', score: '0 - 0', enCours: false },
    { equipe1: 'Team Alpha', equipe2: 'Team Beta', date: new Date(2025, 5, 2), heure: '20h00', jeu: 'CS2', image: 'https://picsum.photos/400/200?random=1', enCours: false, fini:true , score: '3-0' },
    { equipe1: 'Squad X', equipe2: 'Warriors', date: new Date(2025, 5, 3), heure: '18h30', jeu: 'CS2', image: 'https://picsum.photos/400/200?random=2', enCours: false },
    { equipe1: 'Eagles', equipe2: 'Titans', date: new Date(2025, 5, 4), heure: '21h00', jeu: 'CS2', image: 'https://picsum.photos/400/200?random=3', enCours: false },
    { equipe1: 'Phoenix', equipe2: 'Dragons', date: new Date(2025, 5, 5), heure: '19h00', jeu: 'CS2', image: 'https://picsum.photos/400/200?random=4', enCours: true },
    { equipe1: 'Sharks', equipe2: 'Wolves', date: new Date(2025, 5, 6), heure: '17h30', jeu: 'CS2', image: 'https://picsum.photos/400/200?random=5', enCours: false },
    { equipe1: 'Knights', equipe2: 'Giants', date: new Date(2025, 5, 7), heure: '22h00', jeu: 'CS2', image: 'https://picsum.photos/400/200?random=6', enCours: false },
    { equipe1: 'Falcons', equipe2: 'Lions', date: new Date(2025, 5, 8), heure: '16h00', jeu: 'CS2', image: 'https://picsum.photos/400/200?random=7', enCours: false },
    { equipe1: 'Raptors', equipe2: 'Bulls', date: new Date(2025, 5, 9), heure: '20h30', jeu: 'CS2', image: 'https://picsum.photos/400/200?random=8', enCours: true },
    { equipe1: 'Pirates', equipe2: 'Vikings', date: new Date(2025, 5, 10), heure: '18h00', jeu: 'CS2', image: 'https://picsum.photos/400/200?random=9', enCours: false }
  ];

  selectedMatch: any = null;

  openMatch(match: any) {
    this.selectedMatch = match;
  }

  closeModal() {
    this.selectedMatch = null;
  }

  get matchsEnCours() {
    return this.matchs.filter(match => match.enCours && !match.fini);
  }
  get matchsFinis() {
    return this.matchs.filter(match => match.fini);
  }
  get autresMatchs() {
    return this.matchs.filter(match => !match.enCours && !match.fini);
  }
}

