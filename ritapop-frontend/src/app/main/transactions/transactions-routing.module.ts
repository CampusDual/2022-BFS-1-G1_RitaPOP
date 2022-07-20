import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TransactionsHomeComponent } from './transactions-home/transactions-home.component';
import { TransactionsNewComponent } from './transactions-new/transactions-new.component';


const routes: Routes = [{
  path: '',
  component: TransactionsHomeComponent
},
{
  path:"new",
  component: TransactionsNewComponent}];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TransactionsRoutingModule { }
