import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

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
  @Output()
  onVote: EventEmitter<number>;
  selectedOption = -1;

  constructor() {
    this.onVote = new EventEmitter<number>();
  }

  ngOnInit(): void {
  }

  vote(optionIndex: number) {
    if(this.selectedOption === -1){
      this.selectedOption = optionIndex;
      this.onVote.next(optionIndex)
    }
  }
}
