import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})

export class MainComponent implements OnInit{

  username : string;

  constructor(){
  }
  ngOnInit(){
    this.username = "cincuenta";
  }
}

export class MainModule {}

