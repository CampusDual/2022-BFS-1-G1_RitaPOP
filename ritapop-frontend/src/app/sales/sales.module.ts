import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SalesRoutingModule } from './sales-routing.module';
import { SalesHomeComponent } from './sales-home/sales-home.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';

@NgModule({
  declarations: [SalesHomeComponent],
  imports: [
    CommonModule,
    OntimizeWebModule,
    SalesRoutingModule
  ]
})
export class SalesModule { }
