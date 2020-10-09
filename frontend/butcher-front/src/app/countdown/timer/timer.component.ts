import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CountdownService, Time} from '../../../services/common/countdown.service';

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrls: ['./timer.component.scss']
})
export class TimerComponent implements OnInit {
  @Input()
  countDownDate: Date;
  @Output()
  finished: EventEmitter<boolean>;

  time: Time;

  constructor(private timeCalculatorService: CountdownService) {
    this.finished = new EventEmitter<boolean>();
  }

  ngOnInit(): void {
    this.timeCalculatorService.getCountdown(this.countDownDate).subscribe({
      next: (newTime) => {
        this.time = newTime;
      },
      error: () => {
      },
      complete: () => {
        this.finished.emit(true);
      }
    });


  }

}
