import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Wizard } from '../shared/wizard.model';
import { WizardService } from '../shared/wizard.service';

@Component({
  selector: 'app-wizard-detail',
  templateUrl: './wizard-detail.component.html',
  styleUrls: ['./wizard-detail.component.css']
})
export class WizardDetailComponent implements OnInit {
  
  wizard: Wizard | undefined
  wizardId: number = 0

  constructor(private wizardService: WizardService,
    private router: Router) { }

  ngOnInit(): void {
    this.wizardId = Number(localStorage.getItem("wizardId"))
    this.getWizard()
  }

  
  getWizard() {
    this.wizardService.getWizard(this.wizardId).subscribe(
      res => {
        this.wizard = res
        console.log(res)
      }
    )
  }
  

  goBack() {
    this.router.navigate(["/wizards"])
  }

}
