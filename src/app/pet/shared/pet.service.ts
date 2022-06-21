import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Pet } from './pet.model';

@Injectable({
  providedIn: 'root'
})
export class PetService {
  private url = "http://localhost:8080/api/pets"

  constructor(private http: HttpClient) { }

  getPets(): Observable<Pet[]> {
    return this.http.get<Array<Pet>>(this.url);
    //.pipe(map(res => {return res['pets']}));
  }

  getPet(id: number): Observable<any> { //Pet
    return this.getPets().pipe(map(Pets => Pets.find(Pet => Pet.id === id)))
  }

  savePet(Pet: Pet): Observable<Pet> {
    console.log("save Pet", Pet)

    return this.http.post<Pet>(this.url, Pet)
  }

  updatePet(Pet: Pet): Observable<Pet> {
    return this.http.put<Pet>(this.url + "/" + Pet.id, Pet)
  }

  deletePet(id: number): Observable<any> {
    return this.http.delete(this.url + "/" + id)
  }

  filterPets(name: string) {
    if (name == "") {
      alert("you shoule write a name")
    }
    return this.http.get<Array<Pet>>(this.url + "/filter/" + name);
    //.pipe(map(res => {return res['pets']}));
  }

  // sortPets() {
  //   return this.http.get<Array<Pet>>(this.url + "/sort").pipe(map(res => {return res['pets']}));
  // }
}
