import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WizardService } from '../shared/wizard.service';

@Component({
  selector: 'app-wizard-new',
  templateUrl: './wizard-new.component.html',
  styleUrls: ['./wizard-new.component.css']
})
export class WizardNewComponent implements OnInit {

  constructor(private wizardService: WizardService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveWizard(name:string, age: string, pet: string) {
    if(name == "" || age == "" || pet == ""){
      alert("All fields must be completed")
      return
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

    this.wizardService.saveWizard({
      id: 0,
      name: name,
      age: Number(age),
      pet: pet
    }).subscribe(wizard => [console.log(wizard), alert("Wizard saved"), this.router.navigate(["/wizards"])])

  }

}
