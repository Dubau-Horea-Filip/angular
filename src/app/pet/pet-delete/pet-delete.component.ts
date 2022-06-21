import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PetService } from '../shared/pet.service';

@Component({
  selector: 'app-pet-delete',
  templateUrl: './pet-delete.component.html',
  styleUrls: ['./pet-delete.component.css']
})
export class PetDeleteComponent implements OnInit {

  constructor(private petService: PetService,
    private router: Router) { }

  ngOnInit(): void {
  }

  removePet(id: string) {
    if(id == "" || Number(id) < 0 || !Number(id)){
      alert("Id is not valid")
      return
    } 

    this.petService.deletePet(Number(id)).subscribe(pet => [console.log(pet), alert("Pet deleted"), this.router.navigate(["/pets"])])
  }

}
