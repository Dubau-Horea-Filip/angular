import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WizardService } from '../shared/wizard.service';

@Component({
  selector: 'app-wizard-delete',
  templateUrl: './wizard-delete.component.html',
  styleUrls: ['./wizard-delete.component.css']
})
export class WizardDeleteComponent implements OnInit {

  constructor(private wizardService: WizardService,
    private router: Router) { }

  ngOnInit(): void {
  }

  removeWizard(id: string) {
    if(id == "" || Number(id) < 0 || !Number(id)){
      alert("Id is not valid")
      return
    } 

    this.wizardService.deleteWizard(Number(id)).subscribe(wizard => [console.log(wizard), alert("Wizard deleted"), this.router.navigate(["/wizards"])])
  }

}
