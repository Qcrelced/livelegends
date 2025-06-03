import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private emailSubject = new BehaviorSubject<string | null>(localStorage.getItem('adminEmail'));
  email$ = this.emailSubject.asObservable();

  setEmail(email: string) {
    localStorage.setItem('adminEmail', email);
    this.emailSubject.next(email);
  }

  clearEmail() {
    localStorage.removeItem('adminEmail');
    this.emailSubject.next(null);
  }
}