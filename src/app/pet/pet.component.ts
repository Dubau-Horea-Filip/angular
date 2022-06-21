import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pet } from './shared/pet.model';
import { PetService } from './shared/pet.service';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
