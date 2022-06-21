import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { CastedSpell } from './castedSpell.model';

@Injectable({
  providedIn: 'root'
})
export class CastedSpellService {

  private url = "http://localhost:8080/api/casted_spells"

  constructor(private http: HttpClient) { }

  getCastedSpells(): Observable<CastedSpell[]> {
    return this.http.get<Array<CastedSpell>>(this.url);
    //.pipe(map(res => {return res['castedSpells']}));
  }

  getCastedSpell(id: number): Observable<CastedSpell> {
    return this.getCastedSpells().pipe(map(casted_spells => casted_spells.find(CastedSpell => CastedSpell.id === id)))
  }

  saveCastedSpell(CastedSpell: CastedSpell): Observable<CastedSpell> {
    console.log("save CastedSpell", CastedSpell)

    return this.http.post<CastedSpell>(this.url, CastedSpell)
  }

  updateCastedSpell(CastedSpell: CastedSpell): Observable<CastedSpell> {
    return this.http.put<CastedSpell>(this.url + "/" + CastedSpell.id, CastedSpell)
  }

  deleteCastedSpell(id: number): Observable<any> {
    return this.http.delete(this.url + "/" + id)
  }

  // filterCastedSpells(name: string) {
  //   return this.http.get<Array<CastedSpell>>(this.url + "/filter/" + name).pipe(map(res => {return res['castedSpells']}));
  // }

  // sortCastedSpells() {
  //   return this.http.get<Array<CastedSpell>>(this.url + "/sort").pipe(map(res => {return res['castedSpells']}));
  // }
}
