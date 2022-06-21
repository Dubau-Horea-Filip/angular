import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pet } from '../shared/pet.model';
import { PetService } from '../shared/pet.service';

@Component({
  selector: 'app-pet-detail',
  templateUrl: './pet-detail.component.html',
  styleUrls: ['./pet-detail.component.css']
})
export class PetDetailComponent implements OnInit {

  pet: Pet | undefined
  petId: number = 0

  constructor(private petService: PetService,
    private router: Router) { }

  ngOnInit(): void {
    this.petId = Number(localStorage.getItem("petId"))
    this.getPet()
  }

  getPet() {
    this.petService.getPet(this.petId).subscribe(
      res => {
        this.pet = res
        console.log(res)
      }
    )
  }

  goBack() {
    this.router.navigate(["/wizards"])
  }

}
