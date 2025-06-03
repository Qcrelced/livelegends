import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { AccueilComponent } from './accueil/accueil.component';
import { FooterComponent } from './footer/footer.component';
import {  ConnexionComponent } from './connexion/connexion.component';
import { MatchComponent } from './match/match.component';
import {AdminComponent} from './admin/admin.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {path: 'accueil', component: AccueilComponent},
  {path: 'footer', component: FooterComponent},
  {path: 'navbar', component: NavbarComponent},
  {path: 'connexion', component: ConnexionComponent},
  {path: 'match', component: MatchComponent},
  {path: 'admin', component: AdminComponent, canActivate: [AuthGuard]},


  {
    path: '',
    redirectTo: '/accueil',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
