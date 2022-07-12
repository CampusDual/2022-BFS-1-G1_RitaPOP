import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TransactionsRoutingModule } from './transactions-routing.module';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { TransactionsHomeComponent } from './transactions-home/transactions-home.component';


@NgModule({
  declarations: [TransactionsHomeComponent],
  imports: [
    CommonModule,
    OntimizeWebModule,
    TransactionsRoutingModule
  ]
})
export class TransactionsModule { }
