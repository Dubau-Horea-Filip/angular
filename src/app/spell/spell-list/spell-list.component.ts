import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Spell } from '../shared/spell.model';
import { SpellService } from '../shared/spell.service';

@Component({
  selector: 'app-spell-list',
  templateUrl: './spell-list.component.html',
  styleUrls: ['./spell-list.component.css']
})
export class SpellListComponent implements OnInit {

  spells: Array<Spell> = []
  selectedSpell: Spell | undefined 

  constructor(private spellService: SpellService,
    private router: Router) { }

    ngOnInit(): void {
      this.getSpells()
  }

  getSpells() {
    this.spellService.getSpells().subscribe(
      res => {
        this.spells = res as Spell[]
      }
    )
  }

  onSelect(wizard: Spell) {
    this.selectedSpell = wizard
    localStorage.setItem("spellId", this.selectedSpell.id.toString())
  }

  gotoDetail() {
    this.router.navigate(["/spells/details"])
  }

}
