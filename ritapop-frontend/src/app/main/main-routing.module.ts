import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from 'ontimize-web-ngx';

import { MainComponent } from './main.component';

export const routes: Routes = [
  {
    path: '',
    component: MainComponent,
    canActivate: [AuthGuardService],
    children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      { path: 'home', loadChildren: () => import('./home/home.module').then(m => m.HomeModule) },
      { path: 'user', loadChildren: () => import('./users/users.module').then(m => m.UsersModule) },
      { path: 'clients', loadChildren: () => import('./clients/clients.module').then(m => m.ClientsModule)},
      { path: 'transactions', loadChildren: () => import('./transactions/transactions.module').then(m => m.TransactionsModule)}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
