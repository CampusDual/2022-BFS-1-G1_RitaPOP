import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientsRoutingModule } from './clients-routing.module';
import { OntimizeWebModule } from 'ontimize-web-ngx';
import { ClientsHomeComponent } from './clients-home/clients-home.component';
import { ClientsVipRenderComponent } from './clients-home/clients-vip-render/clients-vip-render.component';


@NgModule({
  declarations: [ClientsHomeComponent, ClientsVipRenderComponent],
  imports: [
    CommonModule,
    OntimizeWebModule,
    ClientsRoutingModule
  ]
})
export class ClientsModule { }
