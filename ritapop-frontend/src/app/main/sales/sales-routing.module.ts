import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SalesHomeComponent } from './sales-home/sales-home.component';

const routes: Routes =  [{
  path : '',
  component: SalesHomeComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SalesRoutingModule { }

