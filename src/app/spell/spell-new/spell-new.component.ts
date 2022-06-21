import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SpellService } from '../shared/spell.service';

@Component({
  selector: 'app-spell-new',
  templateUrl: './spell-new.component.html',
  styleUrls: ['./spell-new.component.css']
})
export class SpellNewComponent implements OnInit {

  constructor(private spellService: SpellService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveSpell(name:string, description: string) {
    if(name == "" || description == ""){
      alert("All fields must be completed")
      return
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

    this.spellService.saveSpell({
      id: 0,
      name: name,
      description: description
    }).subscribe(PetDetailComponent => [console.log(PetDetailComponent), alert("Spell saved"), this.router.navigate(["/spells"])])

  }

}
