import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientsHomeComponent } from './clients-home/clients-home.component';
import { ClientsNewComponent } from './clients-new/clients-new.component';



const routes: Routes = [{
  path: '',
  component: ClientsHomeComponent
},{
  path: 'new',
  component: ClientsNewComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientsRoutingModule { }
