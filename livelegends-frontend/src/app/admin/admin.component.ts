import { Component } from '@angular/core';


interface Match {
  id: number;
  equipeA: string;
  equipeB: string;
  scoreA: number;
  scoreB: number;
  etat: 'Pas commencé' | 'En cours' | 'Fini';
  edition?: boolean;
}

@Component({
  selector: 'app-admin',
  standalone: false,
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  matchs: Match[] = [
    { id: 1, equipeA: 'Team Alpha', equipeB: 'Team Beta', scoreA: 2, scoreB: 1, etat: 'Fini' },
    { id: 2, equipeA: 'Team Gamma', equipeB: 'Team Delta', scoreA: 0, scoreB: 0, etat: 'En cours' },
    { id: 3, equipeA: 'Team Epsilon', equipeB: 'Team Zeta', scoreA: 0, scoreB: 0, etat: 'Pas commencé' },
    { id: 4, equipeA: 'Team Omega', equipeB: 'Team Sigma', scoreA: 3, scoreB: 2, etat: 'Fini' },
    { id: 5, equipeA: 'Team Lambda', equipeB: 'Team Theta', scoreA: 1, scoreB: 1, etat: 'En cours' },
    { id: 6, equipeA: 'Team Pi', equipeB: 'Team Rho', scoreA: 0, scoreB: 0, etat: 'Pas commencé' },
    { id: 7, equipeA: 'Team Kappa', equipeB: 'Team Iota', scoreA: 4, scoreB: 3, etat: 'Fini' },
    { id: 8, equipeA: 'Team Phoenix', equipeB: 'Team Hydra', scoreA: 2, scoreB: 2, etat: 'En cours' },
    { id: 9, equipeA: 'Team Cerberus', equipeB: 'Team Griffin', scoreA: 0, scoreB: 1, etat: 'Pas commencé' },
    { id: 10, equipeA: 'Team Unicorn', equipeB: 'Team Dragon', scoreA: 5, scoreB: 4, etat: 'Fini' },
    { id: 11, equipeA: 'Team Minotaur', equipeB: 'Team Chimera', scoreA: 1, scoreB: 3, etat: 'En cours' },
    { id: 12, equipeA: 'Team Kraken', equipeB: 'Team Leviathan', scoreA: 0, scoreB: 0, etat: 'Pas commencé' }
  ];

  etats = ['Pas commencé', 'En cours', 'Fini'];

  editMatch(match: Match) {
    match.edition = true;
  }

  saveMatch(match: Match) {
    match.edition = false;
    // Appeler ici le service pour sauvegarder côté serveur
  }

  cancelEdit(match: Match) {
    match.edition = false;
    // Recharger les valeurs si besoin
  }
}
