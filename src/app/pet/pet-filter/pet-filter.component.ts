import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pet } from '../shared/pet.model';
import { PetService } from '../shared/pet.service';

@Component({
  selector: 'app-pet-filter',
  templateUrl: './pet-filter.component.html',
  styleUrls: ['./pet-filter.component.css']
})
export class PetFilterComponent implements OnInit {

  pets: Array<Pet> =[]
  petsWithAngular: Array<Pet> = []

  constructor(private petservice: PetService,
    private router: Router) { }

  ngOnInit(): void {
    // this.getPets()
  }

  getPets() {
    this.petservice.getPets().subscribe(
      res => {
        this.pets = res as Pet[]
      }
    )
  }

  filterPets(name:string) {
    this.petservice.filterPets(name).subscribe(
      res => {
        this.pets = res
        console.log(this.pets)
      }
    )
  }

  filterPetsAngular(name: string) {
    this.petservice.getPets().subscribe(
      pets => this.petsWithAngular = pets.filter(wiz => wiz.name.includes(name))
    )
  }

}
