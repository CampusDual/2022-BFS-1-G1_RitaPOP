import { Component, OnInit } from '@angular/core';
import { OComboComponent, OEmailInputComponent, OIntegerInputComponent, OTextInputComponent } from 'ontimize-web-ngx';
import { ValidationErrors, FormControl } from '@angular/forms';

@Component({
  selector: 'app-sales-new',
  templateUrl: './sales-new.component.html',
  styleUrls: ['./sales-new.component.css']
})
export class SalesNewComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  addDataSeller($event: any, combo: OComboComponent, name: OTextInputComponent, surname: OTextInputComponent,email: OEmailInputComponent, phone_number:OIntegerInputComponent){

    let nameCombo:String=combo.getSelectedRecord()['NAME'];
    let surnameCombo:String=combo.getSelectedRecord()['SURNAME'];
    let emailCombo:String=combo.getSelectedRecord()['EMAIL'];
    let phoneNumberCombo:String=combo.getSelectedRecord()['PHONE_NUMBER'];
    name.setValue('');
    surname.setValue('');
    email.setValue('');
    phone_number.setValue('');
    name.setValue(nameCombo);
    surname.setValue(surnameCombo);
    email.setValue(emailCombo);
    phone_number.setValue(phoneNumberCombo);
  }

  maxValidator(control: FormControl): ValidationErrors  {
    let result = {};
    if (control.value && control.value > 99999999.99) {
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
