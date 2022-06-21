import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Statistics } from './statistics.model';
import { StatisticsService } from './statistics.service';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  constructor(private service: StatisticsService,
    private router: Router) { }

  wizards: Array<Statistics> = []

  ngOnInit(): void {
    this.getStatistics()
  }

  getStatistics() {
    this.service.getStatistics().subscribe(
      res => {
        console.log(res)
        this.wizards = res
      }
    )
  }

}
