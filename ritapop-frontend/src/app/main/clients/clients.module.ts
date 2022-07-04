import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientsRoutingModule } from './clients-routing.module';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { ClientsHomeComponent } from './clients-home/clients-home.component';


@NgModule({
  declarations: [ClientsHomeComponent],
  imports: [
    CommonModule,
    OntimizeWebModule,
    ClientsRoutingModule
  ]
})
export class ClientsModule { }
