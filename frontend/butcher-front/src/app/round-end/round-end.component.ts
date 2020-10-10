import { Component, OnInit } from '@angular/core';
import lottie from "lottie-web";
@Component({
  selector: 'app-round-end',
  templateUrl: './round-end.component.html',
  styleUrls: ['./round-end.component.scss']
})
export class RoundEndComponent implements OnInit {

  winner:number;

  constructor() {}


  ngOnInit(): void {
    this.winner=2;

    let animation = lottie.loadAnimation({
      container: document.getElementById('field'),
      renderer: 'svg',
      loop: false,
      autoplay: true,
      path: '../../assets/animations/field_1-3.json'
    });
  }

}
