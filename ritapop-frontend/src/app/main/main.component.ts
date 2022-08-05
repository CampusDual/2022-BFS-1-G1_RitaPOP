import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})

export class MainComponent implements OnInit {

  constructor(private router: Router) {
  }
  ngOnInit() {
  }

  ngAfterViewInit() {
    const url = this.router.url;
    document.querySelectorAll('o-bar-menu-item').forEach(el => {
      if (el.getAttribute('ng-reflect-route') == url) {
        el.querySelector('a.mat-list-item').classList.add("optionClicked");
      }
    })
  }

  ngOnChange() {
    const url = this.router.url;
    document.querySelectorAll('o-bar-menu-item').forEach(el => {
      if (el.getAttribute('ng-reflect-route') == url) {
        el.querySelector('a.mat-list-item').classList.remove("optionClicked");
      }
    })

  }
}

export class MainModule { }

