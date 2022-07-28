import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router} from '@angular/router';
import { Star } from 'src/app/models/star.model';
import { StarServiceService } from 'src/app/services/star-service.service';

@Component({
  selector: 'app-star-details',
  templateUrl: './star-details.component.html',
  styleUrls: ['./star-details.component.css']
})
export class StarDetailsComponent implements OnInit {

  selectedStar: Star | undefined;
  sao: number;

  page: number = this.route.snapshot.params['sao'];

  constructor(private starService: StarServiceService, private route: ActivatedRoute, private router: Router) { 
  this.sao = 0;
  }

  ngOnInit(): void {
    this.getStarBySAO();
    this.sao = this.route.snapshot.params['sao'] as number;
  }

  getStarBySAO(): void {

    this.sao = this.route.snapshot.params['sao'] as number;

    this.starService.getStarBySAO(this.sao).subscribe(result => {
      let star: Star = new Star(
        result.sao, result.starName, result.starDesignation, result.constellation, result.constellationId, 
        result.brightness, result.type, result.colour, result.distance, result.image, result.explanation);
      this.selectedStar = star;
  }
  );
}

nextPage(): void {

    this.router.navigate(['stars/astronomical', this.sao]).then(() => {
            window.location.reload();
    });
}



}
