import { Component, OnInit } from '@angular/core';
import { Wizard } from '../shared/wizard.model';
import { WizardService } from '../shared/wizard.service';

@Component({
  selector: 'app-wizard-sort',
  templateUrl: './wizard-sort.component.html',
  styleUrls: ['./wizard-sort.component.css']
})
export class WizardSortComponent implements OnInit {

  wizards: Array<Wizard> = []

  constructor(private wizardService: WizardService) { }

  ngOnInit(): void {
    this.getWizards()
  }

  getWizards() {
    this.wizardService.sortWizards().subscribe(
      res => {
        console.log(res)
        this.wizards = res
      }
    )

  }

}
