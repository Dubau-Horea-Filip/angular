import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CastedSpellService } from '../shared/casted-spell.service';

@Component({
  selector: 'app-casted-spell-new',
  templateUrl: './casted-spell-new.component.html',
  styleUrls: ['./casted-spell-new.component.css']
})
export class CastedSpellNewComponent implements OnInit {

  constructor(private spellService: CastedSpellService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveSpell(wizardId: string, spellId: string, details: string) {
    if(wizardId == "" || details == "" || spellId == ""){
      alert("All fields must be completed")
      return
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

    this.spellService.saveCastedSpell({
      id: 0,
      wizardId: Number(wizardId),
      spellId: Number(spellId),
      details: details
    }).subscribe(PetDetailComponent => [console.log(PetDetailComponent), alert("Casted spell saved"), this.router.navigate(["/casted_spells"])])

  }

}
