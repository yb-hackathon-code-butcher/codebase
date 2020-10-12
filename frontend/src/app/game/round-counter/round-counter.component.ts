import {Component, Input, OnInit} from '@angular/core';
import {CountdownService} from '../../../services/common/countdown.service';

@Component({
  selector: 'app-round-counter',
  templateUrl: './round-counter.component.html',
  styleUrls: ['./round-counter.component.scss']
})
export class RoundCounterComponent implements OnInit {
  @Input()
  endDate: Date;

  seconds: number;

  constructor(private countdownService: CountdownService) { }

  ngOnInit(): void {
    this.countdownService.getCountdown(this.endDate).subscribe((newTime) => {
      this.seconds = newTime.seconds
    })
  }

}
