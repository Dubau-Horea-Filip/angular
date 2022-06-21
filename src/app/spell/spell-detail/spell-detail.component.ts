import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Spell } from '../shared/spell.model';
import { SpellService } from '../shared/spell.service';

@Component({
  selector: 'app-spell-detail',
  templateUrl: './spell-detail.component.html',
  styleUrls: ['./spell-detail.component.css']
})
export class SpellDetailComponent implements OnInit {

  spell: Spell | undefined
  spellId: number = 0

  constructor(private spellService: SpellService,
    private router: Router) { }

  ngOnInit(): void {
    this.spellId = Number(localStorage.getItem("spellId"))
    this.getSpell()
  }

  getSpell() {
    this.spellService.getSpell(this.spellId).subscribe(
      res => {
        this.spell = res
        console.log(res)
      }
    )
  }
  

  goBack() {
    this.router.navigate(["/spells"])
  }

}
