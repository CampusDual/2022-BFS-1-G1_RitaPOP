import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, NavigationEnd, Router } from "@angular/router";
import { Subject } from "rxjs";

@Component({
  selector: "app-main",
  templateUrl: "./main.component.html",
  styleUrls: ["./main.component.scss"],
})
export class MainComponent implements OnInit {

  constructor(private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.setActiveItem();
      }
    });
  }
  
  ngOnInit() {}
  setActiveItem() {
    const url = this.router.url;
    document.querySelectorAll("o-bar-menu-item").forEach((el) => {
      if (el.getAttribute("ng-reflect-route") == url) {
        el.querySelector("a.mat-list-item").classList.add("optionClicked");
      }
      else {
        el.querySelector("a.mat-list-item").classList.remove("optionClicked");
      }
    });
  }

  ngAfterViewInit() {
    const url = this.router.url;
    document.querySelectorAll('o-bar-menu-item').forEach(el => {
      if (el.getAttribute('ng-reflect-route') == url) {
        el.querySelector('a.mat-list-item').classList.add("optionClicked");
      }
    })
  }
}

export class MainModule {}
