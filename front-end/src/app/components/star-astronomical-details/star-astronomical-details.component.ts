import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StarAstronomical } from 'src/app/models/star-astronomical.model';
import { StarServiceService } from 'src/app/services/star-service.service';

@Component({
  selector: 'app-star-astronomical-details',
  templateUrl: './star-astronomical-details.component.html',
  styleUrls: ['./star-astronomical-details.component.css']
})
export class StarAstronomicalDetailsComponent implements OnInit {

  selectedStar: StarAstronomical | undefined;
  sao: number;

  page: number = this.route.snapshot.params['sao'];

  constructor(private starService: StarServiceService, private route: ActivatedRoute, private router: Router) { 
    this.sao = 0;
  }

  ngOnInit(): void {
    this.getAstronomicalStarBySAO();
    this.sao = this.route.snapshot.params['sao'] as number;
  }

  getAstronomicalStarBySAO(): void {

    this.sao = this.route.snapshot.params['sao'] as number;

    this.starService.getAstronomicalStarBySAO(this.sao).subscribe(result => {
      let star: StarAstronomical = new StarAstronomical(
        result.sao, result.starName, result.starDesignation, result.constellation, result.constellationId,
        result.appMagnitude, result.absMagnitude, result.spectrum, result.colour, result.rightAscension, result.declination, result.distance, result.image);
      this.selectedStar = star;
  }
  );
}
 

previousPage():void{
  if(this.page > 1){
    this.page--;
    this.router.navigate(['/stars', this.sao]).then(() => {
      window.location.reload();
    });
  }
}


}
