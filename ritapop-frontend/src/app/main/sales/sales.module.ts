import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SalesRoutingModule } from './sales-routing.module';
import { SalesHomeComponent } from './sales-home/sales-home.component';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { SalesNewComponent } from './sales-new/sales-new.component';
import { SalesDetailComponent } from './sales-detail/sales-detail.component';

@NgModule({
  declarations: [SalesHomeComponent, SalesNewComponent, SalesDetailComponent],
  imports: [
    CommonModule,
    OntimizeWebModule,
    SalesRoutingModule
  ]
})
export class SalesModule { }
