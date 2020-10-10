import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-option-list',
  templateUrl: './option-list.component.html',
  styleUrls: ['./option-list.component.scss']
})
export class OptionListComponent implements OnInit {
  optionLetters = ['A', 'B', 'C', 'D'];
  @Input()
  teamName: string;
  @Input()
  options: {name: string, chance: number}[];
  @Input()
  tempResults: { percent: number; }[];

  constructor() { }

  ngOnInit(): void {
  }

}
