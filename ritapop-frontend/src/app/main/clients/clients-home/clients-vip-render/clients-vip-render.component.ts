import { ViewChild, TemplateRef, Injector, Component, OnInit } from '@angular/core';
import { OBaseTableCellRenderer } from 'ontimize-web-ngx';

@Component({
  selector: 'app-clients-vip-render',
  templateUrl: './clients-vip-render.component.html',
  styleUrls: ['./clients-vip-render.component.css']
})
export class ClientsVipRenderComponent extends OBaseTableCellRenderer implements OnInit {

  @ViewChild('templateref', { read: TemplateRef, static: false }) public templateref: TemplateRef<any>;

  constructor(protected injector: Injector) {
    super(injector);

   }

  ngOnInit() {
  }
  getCellData(cellvalue: any, rowvalue?: any): string {
    let checkSales:string;
    if(parseInt(rowvalue["SALES"])>=10){
      return checkSales="VIP";
    } else {
      return checkSales="";
    }
  }

}
