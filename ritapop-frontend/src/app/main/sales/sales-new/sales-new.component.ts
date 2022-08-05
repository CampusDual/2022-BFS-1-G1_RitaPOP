import { Component, OnInit } from '@angular/core';
import { OComboComponent, OTextInputComponent } from 'ontimize-web-ngx';

@Component({
  selector: 'app-sales-new',
  templateUrl: './sales-new.component.html',
  styleUrls: ['./sales-new.component.css']
})
export class SalesNewComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  addNameAndSurnameSeller($event: any, combo: OComboComponent, name: OTextInputComponent, surname: OTextInputComponent){

    alert('Hola');
    //name.setValue=combo.get
  }

}
