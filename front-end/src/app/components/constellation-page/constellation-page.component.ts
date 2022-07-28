import { Component, OnInit } from '@angular/core';
import { Constellation } from 'src/app/models/constellation.model';
import { ConstellationServiceService } from 'src/app/services/constellation-service.service';

@Component({
  selector: 'app-constellation-page',
  templateUrl: './constellation-page.component.html',
  styleUrls: ['./constellation-page.component.css']
})
export class ConstellationPageComponent implements OnInit {

  constellations: Constellation[];

  constructor(private constellationService: ConstellationServiceService) {
    this.constellations = []; 
  }

  ngOnInit(): void {
    this.getConstellations();
  }

  getConstellations(): void {
    this.constellationService.getConstellations().subscribe(
      (response: Constellation[]) => {
        this.constellations = response;
        console.log(response);
      }
    );
  }

}
