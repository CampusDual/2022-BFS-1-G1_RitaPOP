import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SalesDetailComponent } from './sales-detail/sales-detail.component';
import { SalesHomeComponent } from './sales-home/sales-home.component';
import { SalesNewComponent } from './sales-new/sales-new.component';

const routes: Routes =  [{
  path : '',
  component: SalesHomeComponent
},
{
  path: 'new',
  component:SalesNewComponent
},
{
  path: ':ID_SALES',
  component:SalesDetailComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SalesRoutingModule { }

