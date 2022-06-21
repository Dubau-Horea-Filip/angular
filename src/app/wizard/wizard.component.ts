import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  // moduleId: module.id,
  selector: 'app-wizard',
  templateUrl: './wizard.component.html',
  styleUrls: ['./wizard.component.css']
})
export class WizardComponent implements OnInit {

 

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  addWizard() {
    this.router.navigate(["/wizards/new"])
  }

  deleteWizard() {
    this.router.navigate(['/wizards/delete'])
  }

  updateWizard() {
    this.router.navigate(['/wizards/update'])
  }

  filterWizards() {
    this.router.navigate(['/wizards/filter'])
  }

  sortWizarrds() {
    this.router.navigate(['/wizards/sort'])
  }

}
