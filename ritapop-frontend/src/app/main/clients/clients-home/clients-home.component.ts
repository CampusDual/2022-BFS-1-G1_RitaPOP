import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clients-home',
  templateUrl: './clients-home.component.html',
  styleUrls: ['./clients-home.component.css']
})
export class ClientsHomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit(){
    document.querySelectorAll('o-bar-menu nav a');
  }

  ngOnDestroy(){
    document.querySelector('o-bar-menu nav a').classList.remove('optionClicked');
  }

}
