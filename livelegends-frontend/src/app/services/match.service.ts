// livelegends-frontend/src/app/match/match.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class MatchService {
  private apiUrl = 'http://localhost:8080/matchs/matchs'; // adapte si besoin

  constructor(private http: HttpClient) {}

  getMatchs(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl, { withCredentials: true });
  }

  updateMatch(match: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${match.id}`, match);
  }

  addMatch(match: any): Observable<any> {
    return this.http.post(this.apiUrl, match, { withCredentials: true });
  }
}


