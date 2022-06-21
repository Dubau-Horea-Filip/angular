import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Statistics } from './statistics.model';

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  constructor(private http: HttpClient) { }

  getStatistics():Observable<Statistics[]> {
    return this.http.get<Array<Statistics>>('http://localhost:8080/api/wizards/pets')
  }
}
