import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CastedSpellService } from '../shared/casted-spell.service';

@Component({
  selector: 'app-casted-spell-delete',
  templateUrl: './casted-spell-delete.component.html',
  styleUrls: ['./casted-spell-delete.component.css']
})
export class CastedSpellDeleteComponent implements OnInit {

  constructor(private spellService: CastedSpellService,
    private router: Router) { }

  ngOnInit(): void {
  }

  removeSpell(id: string) {
    if(id == "" || Number(id) < 0 || !Number(id)){
      alert("Id is not valid")
      return
    } 

    this.spellService.deleteCastedSpell(Number(id)).subscribe(pet => [console.log(pet), alert("Casted spell deleted"), this.router.navigate(["/casted_spells"])])
  }

}
