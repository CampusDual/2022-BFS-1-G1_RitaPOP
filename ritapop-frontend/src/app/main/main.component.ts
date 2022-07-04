import { Component, OnInit } from '@angular/core';
import { AuthService } from 'ontimize-web-ngx';

import { OntimizeAuthService } from 'ontimize-web-ngx';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent {
  constructor(
    Http : XMLHttpRequest = new XMLHttpRequest(),
    url = 'http://localhost:33333/ritapop/services/rest/users/sessionProfile',
    rol : String
  ){
    Http.open("GET", url);
    Http.send();
    rol = Http.responseText;
  }
}
