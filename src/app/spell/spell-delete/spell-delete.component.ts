import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SpellService } from '../shared/spell.service';

@Component({
  selector: 'app-spell-delete',
  templateUrl: './spell-delete.component.html',
  styleUrls: ['./spell-delete.component.css']
})
export class SpellDeleteComponent implements OnInit {

  constructor(private spellService: SpellService,
    private router: Router) { }

  ngOnInit(): void {
  }

  removeSpell(id: string) {
    if(id == "" || Number(id) < 0 || !Number(id)){
      alert("Id is not valid")
      return
    } 

    this.spellService.deleteSpell(Number(id)).subscribe(pet => [console.log(pet), alert("Spell deleted"), this.router.navigate(["/spells"])])
  }

}
