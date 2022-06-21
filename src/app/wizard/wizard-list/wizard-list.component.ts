import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Wizard } from '../shared/wizard.model';
import { WizardService } from '../shared/wizard.service';

@Component({
  selector: 'app-wizard-list',
  templateUrl: './wizard-list.component.html',
  styleUrls: ['./wizard-list.component.css']
})
export class WizardListComponent implements OnInit {
  wizards: Array<Wizard> = []
  selectedWizard: Wizard | undefined 

  constructor(private wizardService: WizardService,
    private router: Router) { }

    ngOnInit(): void {
      this.getWizards()
  }

  getWizards() {
    this.wizardService.getWizards().subscribe(
      res => {
        this.wizards = res as Wizard[]
      }
    )
  }

  onSelect(wizard: Wizard) {
    this.selectedWizard = wizard
    localStorage.setItem("wizardId", this.selectedWizard.id.toString())
  }

  gotoDetail() {
    this.router.navigate(["/wizards/details"])
  }

}
