import { Component, OnInit } from '@angular/core';
import { FormControl, ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-clients-detail',
  templateUrl: './clients-detail.component.html',
  styleUrls: ['./clients-detail.component.css']
})
export class ClientsDetailComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  maxPhoneValidator(control: FormControl): ValidationErrors  {
    let result = {};
    if (control.value && control.value > 999999999) {
      result['requiredPhoneNumber'] = true;
    }
    return result;
  }

  minPhoneValidator(control: FormControl): ValidationErrors  {
    let result = {};
    if (control.value && control.value < 100000000) {
      result['requiredPhoneNumber'] = true;
    }
    return result;
  }
}
