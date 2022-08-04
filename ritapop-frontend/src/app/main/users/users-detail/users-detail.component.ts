import { Component, OnInit } from '@angular/core';
import { FormControl, ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-users-detail',
  templateUrl: './users-detail.component.html',
  styleUrls: ['./users-detail.component.css']
})
export class UsersDetailComponent implements OnInit {

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
