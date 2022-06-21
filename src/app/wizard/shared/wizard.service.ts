import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Wizard } from './wizard.model';

@Injectable({
  providedIn: 'root'
})
export class WizardService {
  private url = "http://localhost:8080/api/wizards"

  constructor(private http: HttpClient) { }

  getWizards(): Observable<Wizard[]> {
    return this.http.get<Array<Wizard>>(this.url);
    //.pipe(map(res => {return res['wizards']}));
  }

  
  getWizard(id: number): Observable<any> {    //Wizard
    return this.getWizards()
    .pipe(map(wizards => wizards.find(wizard => wizard.id === id)))
  }
  

  saveWizard(wizard: Wizard): Observable<Wizard> {
    console.log("save wizard", wizard)

    return this.http.post<Wizard>(this.url, wizard)
  }

  updateWizard(wizard: Wizard): Observable<Wizard> {
    return this.http.put<Wizard>(this.url + "/" + wizard.id, wizard)
  }

  deleteWizard(id: number): Observable<any> {
    return this.http.delete(this.url + "/" + id)
  }

  filterWizards(name: string) {
    return this.http.get<Array<Wizard>>(this.url + "/filter/" + name);
    //.pipe(map(res => {return res['wizards']}));
  }

  sortWizards() {
    return this.http.get<Array<Wizard>>(this.url + "/sort");
    //.pipe(map(res => {return res['wizards']}));
  }
}
