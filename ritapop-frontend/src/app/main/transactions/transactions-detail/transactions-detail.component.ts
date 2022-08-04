import { Component, OnInit } from '@angular/core';
import { FormControl, ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-transactions-detail',
  templateUrl: './transactions-detail.component.html',
  styleUrls: ['./transactions-detail.component.css']
})
export class TransactionsDetailComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  maxValidator(control: FormControl): ValidationErrors  {
    let result = {};
    if (control.value && control.value > 999999.99) {
      result['requiredMax'] = true;
    }
    return result;
  }

  minValidator(control: FormControl): ValidationErrors  {
    let result = {};
    if (control.value && control.value < 0) {
      result['requiredMin'] = true;
    }
    return result;
  }

}
