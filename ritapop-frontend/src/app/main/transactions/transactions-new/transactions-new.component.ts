import { Component, OnInit } from '@angular/core';
import { ValidationErrors, FormControl } from '@angular/forms';

@Component({
  selector: 'app-transactions-new',
  templateUrl: './transactions-new.component.html',
  styleUrls: ['./transactions-new.component.css']
})
export class TransactionsNewComponent implements OnInit {

  constructor() {
  }

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
