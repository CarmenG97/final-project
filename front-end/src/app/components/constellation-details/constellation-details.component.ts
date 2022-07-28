import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router} from '@angular/router';
import { Constellation } from 'src/app/models/constellation.model';
import { ConstellationServiceService } from 'src/app/services/constellation-service.service';

@Component({
  selector: 'app-constellation-details',
  templateUrl: './constellation-details.component.html',
  styleUrls: ['./constellation-details.component.css']
})
export class ConstellationDetailsComponent implements OnInit {

  selectedConstellation: Constellation | undefined;

  SAO: number | undefined;

  constellationId: number;
  page: number = this.route.snapshot.params['id'];

  constructor(private constellationService: ConstellationServiceService, private route: ActivatedRoute, private router: Router) { 
    this.constellationId = 0;
  }

  ngOnInit(): void {
    this.getConstellation();
  }

  getConstellation(): void {
    this.constellationId = this.route.snapshot.params['id'] as number;
 
    this.constellationService.getConstellationById(this.constellationId).subscribe(result => {
      let constellation: Constellation = new Constellation(
        result.id, result.constellationName, result.alphaStarName, result.numberOfStars, result.starCuriousDTOList, result.profilePicture, result.secondProfilePicture, result.history);
        console.log(result.starCuriousDTOList);
      this.selectedConstellation = constellation;
  }
  );
}

nextPage(): void {
  if(this.page <= 11){
    this.page++;
    this.router.navigate(['/constellations', this.page ]).then(() => {
      window.location.reload();
    });
  }
}

previousPage():void{
  if(this.page > 1){
    this.page--;
    this.router.navigate(['/constellations', this.page ]).then(() => {
      window.location.reload();
    });
  }
}

}

  

  
