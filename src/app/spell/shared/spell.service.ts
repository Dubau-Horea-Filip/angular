import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Spell } from './spell.model';

@Injectable({
  providedIn: 'root'
})
export class SpellService {
  [x: string]: any;

  private url = "http://localhost:8080/api/spells"

  constructor(private http: HttpClient) { }

  getSpells(): Observable<Spell[]> {
    return this.http.get<Array<Spell>>(this.url);
  }

  
  getSpell(id: number): Observable<Spell> {
    return this.getSpells().pipe(map(spells => spells.find(Spell => Spell.id === id)))
  }
  

  saveSpell(Spell: Spell): Observable<Spell> {
    console.log("save Spell", Spell)

    return this.http.post<Spell>(this.url, Spell)
  }

  updateSpell(Spell: Spell): Observable<Spell> {
    return this.http.put<Spell>(this.url + "/" + Spell.id, Spell)
  }

  deleteSpell(id: number): Observable<any> {
    return this.http.delete(this.url + "/" + id)
  }

  filterSpells(name: string) {
    return this.http.get<Array<Spell>>(this.url + "/filter/" + name);
  }

  sortSpells() {
    return this.http.get<Array<Spell>>(this.url + "/sort");
  }
}
