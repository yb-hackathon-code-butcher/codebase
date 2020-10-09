import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-countdown',
  templateUrl: './countdown.component.html',
  styleUrls: ['./countdown.component.scss']
})
export class CountdownComponent implements OnInit {
  start: Date;

  constructor() {
    this.start = new Date("Oct 10, 2020 11:00:00");
  }

  ngOnInit(): void {
  }

}
