import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pet } from '../shared/pet.model';
import { PetService } from '../shared/pet.service';

@Component({
  selector: 'app-pet-list',
  templateUrl: './pet-list.component.html',
  styleUrls: ['./pet-list.component.css']
})
export class PetListComponent implements OnInit {

  

  pets: Array<Pet> = []
  selectedPet: Pet 

  constructor(private petService: PetService,
    private router: Router) { }

    ngOnInit(): void {
      this.getPets()
  }

  getPets() {
    this.petService.getPets().subscribe(
      res => {
        this.pets = res as Pet[]
      }
    )
  }

  onSelect(wizard: Pet) {
    this.selectedPet = wizard
    localStorage.setItem("petId", this.selectedPet.id.toString())
  }

  gotoDetail() {
    this.router.navigate(["/pets/details"])
  }

}
