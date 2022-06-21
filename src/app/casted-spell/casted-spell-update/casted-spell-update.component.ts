import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CastedSpellService } from '../shared/casted-spell.service';

@Component({
  selector: 'app-casted-spell-update',
  templateUrl: './casted-spell-update.component.html',
  styleUrls: ['./casted-spell-update.component.css']
})
export class CastedSpellUpdateComponent implements OnInit {

  constructor(private spellService: CastedSpellService,
    private router: Router) { }

  ngOnInit(): void {
  }

  

  updateSpell(id: string, wizardId: string, spellId: string, details: string) {
    if(wizardId == "" || details == "" || spellId == ""){
      alert("All fields must be completed")
      return
    }

    if (!Number(id) || Number(id) < 0) {
      alert("Id is not valid")
    }

    if (!Number(wizardId) || Number(wizardId) < 0) {
      alert("wizardId is not valid")
      return
    }

    var regex = /[a-z]/g;
    if (!regex.test(details)) {
      alert("details is not valid")
      return
    }

    this.spellService.updateCastedSpell({
      id: Number(id),
      wizardId: Number(wizardId),
      spellId: Number(spellId),
      details: details
    }).subscribe(PetDetailComponent => [console.log(PetDetailComponent), alert("Casted spell updated"), this.router.navigate(["/casted_spells"])])

  }

}
