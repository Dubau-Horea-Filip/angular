import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PetService } from '../shared/pet.service';


@Component({
  selector: 'app-pet-update',
  templateUrl: './pet-update.component.html',
  styleUrls: ['./pet-update.component.css']
})
export class PetUpdateComponent implements OnInit {

  constructor(private petService: PetService,
    private router: Router) { }

  ngOnInit(): void {
  }

  updatePet(id: string, name:string, breed: string, wid: string) {
    if(name == "" || wid == "" || breed == "" || id == ""){
      alert("All fields must be completed")
      return
    }

    if (!Number(id) || Number(id) < 0){
      alert("Id is not valid")
    }

    var regex = /[a-z]/g;
    if (!regex.test(name)) {
      alert("Name is not valid")
      return
    }

    if (!regex.test(breed)) {
      alert("Breed is not valid")
      return
    }

    if (!Number(wid) || Number(wid) < 0){
      alert("WizardId is not valid")
    }

    this.petService.updatePet({
      id: Number(id),
      name: name,
      breed: breed,
      wid: Number(wid)
    }).subscribe(PetDetailComponent => [console.log(PetDetailComponent), alert("Pet updated"), this.router.navigate(["/pets"])])

  }

}
