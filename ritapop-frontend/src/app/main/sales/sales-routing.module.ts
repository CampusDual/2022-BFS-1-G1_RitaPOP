import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SalesHomeComponent } from './sales-home/sales-home.component';
import { SalesNewComponent } from './sales-new/sales-new.component';

const routes: Routes =  [{
  path : '',
  component: SalesHomeComponent
},
{
  path: ':ID_SALES',
  component:SalesNewComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SalesRoutingModule { }

