import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountdownService {

  constructor() {
  }

  private getTimeUntilDate(date: Date): Time {
    const now = new Date().getTime();
    const start = date.getTime();

    const distance = start - now;
    const days = Math.floor(distance / (1000 * 60 * 60 * 24));
    const hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    const minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    const seconds = Math.floor((distance % (1000 * 60)) / 1000);
    return {days, hours, minutes, seconds, distance};
  }

  getCountdown(date: Date): Observable<Time> {
    const initTime = this.getTimeUntilDate(date);
    const subject = new BehaviorSubject<Time>(initTime);
    if (initTime.distance < 0) {
      subject.complete();
    }

    const interval = setInterval(() => {
      const time = this.getTimeUntilDate(date);
      subject.next(time);
      if (time.distance < 0) {
        clearInterval(interval);
        subject.complete();
      }
    }, 1000);

    return subject.asObservable();
  }

}

export interface Time {
  days: number
  hours: number
  minutes: number
  seconds: number
  distance: number
}
