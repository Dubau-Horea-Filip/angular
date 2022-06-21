import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WizardService } from '../shared/wizard.service';

@Component({
  selector: 'app-wizard-update',
  templateUrl: './wizard-update.component.html',
  styleUrls: ['./wizard-update.component.css']
})
export class WizardUpdateComponent implements OnInit {

  constructor(private wizardService: WizardService,
    private router: Router) { }

  ngOnInit(): void {
  }

  updateWizard(id: string, name: string, age: string, pet: string) {
    if(name == "" || age == "" || pet == "" || id == ""){
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

    if (!regex.test(pet)) {
      alert("PetName is not valid")
      return
    }

    if (!Number(age) || Number(age) < 0){
      alert("Age is not valid")
    }
    this.wizardService.updateWizard({
      id: Number(id),
      name: name,
      age: Number(age),
      pet: pet
    }).subscribe(wizard => [console.log(wizard), alert("Wizard saved"), this.router.navigate(["/wizards"])])

    
  }

}
