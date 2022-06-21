import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CastedSpellService } from '../shared/casted-spell.service';
import { CastedSpell } from '../shared/castedSpell.model';

@Component({
  selector: 'app-casted-spell-detail',
  templateUrl: './casted-spell-detail.component.html',
  styleUrls: ['./casted-spell-detail.component.css']
})
export class CastedSpellDetailComponent implements OnInit {

  spell: CastedSpell | undefined 
  spellId: number = 0

  constructor(private spellService: CastedSpellService,
    private router: Router) { }

  ngOnInit(): void {
    this.spellId = Number(localStorage.getItem("spellId"))
    this.getSpell()
  }

  getSpell() {
    this.spellService.getCastedSpell(this.spellId).subscribe(
      res => {
        this.spell = res
        console.log(res)
      }
    )
  }

  goBack() {
    this.router.navigate(["/casted_spells"])
  }

}
