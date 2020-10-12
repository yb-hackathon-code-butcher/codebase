import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-ball-possession',
  templateUrl: './ball-possession.component.html',
  styleUrls: ['./ball-possession.component.scss']
})
export class BallPossessionComponent implements OnInit {
  @Input()
  teamName: string;

  constructor() { }

  ngOnInit(): void {
  }

}
