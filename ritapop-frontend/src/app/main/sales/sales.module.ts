import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SalesRoutingModule } from './sales-routing.module';
import { SalesHomeComponent } from './sales-home/sales-home.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { SalesNewComponent } from './sales-new/sales-new.component';

@NgModule({
  declarations: [SalesHomeComponent, SalesNewComponent],
  imports: [
    CommonModule,
    OntimizeWebModule,
    SalesRoutingModule
  ]
})
export class SalesModule { }
