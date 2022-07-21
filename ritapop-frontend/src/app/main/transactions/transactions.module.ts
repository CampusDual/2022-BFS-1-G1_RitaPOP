import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TransactionsRoutingModule } from './transactions-routing.module';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { TransactionsHomeComponent } from './transactions-home/transactions-home.component';
import { TransactionsNewComponent } from './transactions-new/transactions-new.component';
import { TransactionsDetailComponent } from './transactions-detail/transactions-detail.component';


@NgModule({
  declarations: [TransactionsHomeComponent, TransactionsNewComponent, TransactionsDetailComponent],
  imports: [
    CommonModule,
    OntimizeWebModule,
    TransactionsRoutingModule
  ]
})
export class TransactionsModule { }
