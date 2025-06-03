import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  standalone: false,
})
export class NavbarComponent {
  adminEmail: string | null = null;

  constructor(private auth: AuthService, private router: Router) {
    this.auth.email$.subscribe(email => this.adminEmail = email);
  }

  logout() {
    this.auth.clearEmail();
    this.router.navigate(['/accueil']);
  }
}