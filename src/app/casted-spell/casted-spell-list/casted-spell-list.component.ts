import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SpellService } from 'src/app/spell/shared/spell.service';
import { CastedSpellService } from '../shared/casted-spell.service';
import { CastedSpell } from '../shared/castedSpell.model';

@Component({
  selector: 'app-casted-spell-list',
  templateUrl: './casted-spell-list.component.html',
  styleUrls: ['./casted-spell-list.component.css']
})
export class CastedSpellListComponent implements OnInit {

  spells: Array<CastedSpell> = []
  selectedSpell: CastedSpell | undefined 

  constructor(private spellService: CastedSpellService,
    private router: Router) { }

    ngOnInit(): void {
      this.getSpells()
  }

  getSpells() {
    this.spellService.getCastedSpells().subscribe(
      res => {
        this.spells = res as CastedSpell[]
      }
    )
  }

  onSelect(wizard: CastedSpell) {
    this.selectedSpell = wizard
    localStorage.setItem("spellId", this.selectedSpell.id.toString())
  }

  gotoDetail() {
    this.router.navigate(["/casted_spells/details"])
  }

}
