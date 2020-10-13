import {Component, Input, OnInit} from '@angular/core';
import {CountdownService} from '../../../services/common/countdown.service';

@Component({
  selector: 'app-round-counter',
  templateUrl: './round-counter.component.html',
  styleUrls: ['./round-counter.component.scss']
})
export class RoundCounterComponent implements OnInit {
  @Input()
  set endDate(value: Date) {
    if(this._endDate != value){
      this._endDate = value;
      this.initCounter();
    }
  }
  private _endDate: Date;

  seconds: number;

  constructor(private countdownService: CountdownService) { }

  ngOnInit(): void {
  }

  private initCounter() {
    this.countdownService.getCountdown(this._endDate).subscribe((newTime) => {
      this.seconds = newTime.seconds
    })
  }
}
