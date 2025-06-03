import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router) {}

  canActivate(): boolean {
    const adminEmail = localStorage.getItem('adminEmail');

    if (!adminEmail) {
      
      this.router.navigate(['/connexion']);
      return false;
    }

    return true;
  }
}