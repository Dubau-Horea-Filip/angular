import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Wizard } from '../shared/wizard.model';
import { WizardService } from '../shared/wizard.service';

@Component({
  selector: 'app-wizard-filter',
  templateUrl: './wizard-filter.component.html',
  styleUrls: ['./wizard-filter.component.css']
})
export class WizardFilterComponent implements OnInit {

  wizards: Array<Wizard> =[]
  wizardsWithAngular: Array<Wizard> = []

  constructor(private wizardService: WizardService,
    private router: Router) { }

  ngOnInit(): void {
    this.getWizards
  }

  getWizards() {
    this.wizardService.getWizards().subscribe(
      res => {
        this.wizards = res as Wizard[]
      }
    )
  }

  filterWizards(name:string) {
    this.wizardService.filterWizards(name).subscribe(
      res => {
        this.wizards = res
        console.log(this.wizards)
      }
    )
  }

  filterWizardsAngular(name: string) {
    this.wizardService.getWizards().subscribe(
      wizards => this.wizardsWithAngular = wizards.filter(wiz => wiz.name.includes(name))
    )
  }

}
