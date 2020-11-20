import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-vote-result-bar',
  templateUrl: './vote-result-bar.component.html',
  styleUrls: ['./vote-result-bar.component.scss']
})
export class VoteResultBarComponent implements OnInit {
  @Input()
  items: { percent: number }[];
  @Input()
  teamName: string;

  constructor() {
  }

  ngOnInit(): void {
  }

}
