import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SpellService } from './shared/spell.service';

@Component({
  selector: 'app-spell',
  templateUrl: './spell.component.html',
  styleUrls: ['./spell.component.css']
})
export class SpellComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  
}
