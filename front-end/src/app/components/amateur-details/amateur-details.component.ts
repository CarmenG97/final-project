
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-amateur-details',
  templateUrl: './amateur-details.component.html',
  styleUrls: ['./amateur-details.component.css']
})
export class AmateurDetailsComponent implements OnInit {

  // selectedAmateur: Amateur | undefined;
  amateurId: number;
  amateurName: string;
  amateurEmail: string;
  amateurPhoto: string;

  constructor(private route: ActivatedRoute, private authService: AuthService) { 
    this.amateurId = 0;
    this.amateurName = '';
    this.amateurEmail = '';
    this.amateurPhoto = '';
  }

   ngOnInit(): void {
    this.amateurId = JSON.parse(localStorage.getItem('currentUser')as string).id as number;
    this.amateurName = JSON.parse(localStorage.getItem('currentUser')as string).name as string;
    this.amateurEmail = JSON.parse(localStorage.getItem('currentUser')as string).email as string;
    this.amateurPhoto = JSON.parse(localStorage.getItem('currentUser')as string).photo as string;

  }

  // getAmateur(): void {

  //   this.amateurId = this.route.snapshot.params['id'] as number;

  //   this.authService.getAmateurById(this.amateurId).subscribe(result => {
  //     let amateur: Amateur = new Amateur(
  //       result.id, result.name, result.email, result.yearsOfExperience, result.password, result.photo);
  //       console.log(result.id, result.name);
  //       console.log(result.email, result.password);
  //     this.selectedAmateur = amateur;
  //   }
  //   );
  // }

}




