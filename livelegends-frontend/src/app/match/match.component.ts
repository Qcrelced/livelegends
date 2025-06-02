import { Component, OnInit } from '@angular/core';
import { MatchService } from '../services/match.service';

@Component({
  selector: 'app-match',
  standalone: false,
  templateUrl: './match.component.html',
  styleUrl: './match.component.css'
})
export class MatchComponent implements OnInit {
  admins: any[] = [];
  selectedMatch: any = null;
   // Assurez-vous que l'URL correspond à votre API

  constructor(private matchService: MatchService) {}

  ngOnInit() {
    this.matchService.getMatchs().subscribe(data => {
      // Adapter si besoin pour correspondre à la structure attendue
      this.admins = data;
    });
  }

  openMatch(match: any) {
    this.selectedMatch = match;
  }

  closeModal() {
    this.selectedMatch = null;
  }

  get matchsEnCours() {
    return this.admins.filter(match => match.enCours && !match.fini);
  }
  get matchsFinis() {
    return this.admins.filter(match => match.fini);
  }
  get autresMatchs() {
    return this.admins.filter(match => !match.enCours && !match.fini);
  }
}
