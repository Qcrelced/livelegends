import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
  standalone: false
})
export class ConnexionComponent {
  email: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(
    private http: HttpClient,
    private router: Router,
    private auth: AuthService
  ) {}

  login(): void {
    this.http.post('http://localhost:8080/admin/login', {
      email: this.email,
      password: this.password
    }, { responseType: 'text' }).subscribe({
      next: response => {
        this.auth.setEmail(this.email);
        this.router.navigate(['/admin']);
      },
      error: err => {
        this.errorMessage = 'Identifiants invalides';
      }
    });
  }
}