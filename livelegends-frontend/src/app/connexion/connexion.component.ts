import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  standalone: false,
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent {
  email: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  login(): void {
    this.http.post('http://localhost:8080/admin/login', {
      email: this.email,
      password: this.password
    }, { responseType: 'text' }).subscribe({
      next: response => {
        this.router.navigate(['/admin']);
      },
      error: err => {
        this.errorMessage = 'Identifiants invalides';
      }
    });
  }
}
