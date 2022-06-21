import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PetService } from '../shared/pet.service';

@Component({
  selector: 'app-pet-new',
  templateUrl: './pet-new.component.html',
  styleUrls: ['./pet-new.component.css']
})
export class PetNewComponent implements OnInit {

  constructor(private petService: PetService,
    private router: Router) { }

  ngOnInit(): void {
  }

  savePet(name:string, breed: string, wid: string) {
    if(name == "" || wid == "" || breed == ""){
      alert("All fields must be completed")
      return
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

    this.petService.savePet({
      id: 0,
      name: name,
      breed: breed,
      wid: Number(wid)
    }).subscribe(PetDetailComponent => [console.log(PetDetailComponent), alert("Pet saved"), this.router.navigate(["/pets"])])

  }

}
