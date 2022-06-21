import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SpellService } from '../shared/spell.service';

@Component({
  selector: 'app-spell-update',
  templateUrl: './spell-update.component.html',
  styleUrls: ['./spell-update.component.css']
})
export class SpellUpdateComponent implements OnInit {

  constructor(private spellService: SpellService,
    private router: Router) { }

  ngOnInit(): void {
  }

  updateSpell(id: string, name: string, description: string) {
    if (name == "" || description == "" || id == "") {
      alert("All fields must be completed")
      return
    }

    if (!Number(id) || Number(id) < 0) {
      alert("Id is not valid")
    }

    var regex = /[a-z]/g;
    if (!regex.test(name)) {
      alert("Name is not valid")
      return
    }

    if (!regex.test(description)) {
      alert("Description is not valid")
      return
    }

    this.spellService.updateSpell({
      id: Number(id),
      name: name,
      description: description,
    }).subscribe(PetDetailComponent => [console.log(PetDetailComponent), alert("Spell updated"), this.router.navigate(["/spells"])])

  }
}
