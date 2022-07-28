import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StarAstronomical } from '../models/star-astronomical.model';
import { Star } from '../models/star.model';

@Injectable({
  providedIn: 'root'
})
export class StarServiceService {

  private readonly BASE_URL='http://localhost:8080';
  constructor(
    private http: HttpClient,
  ) { }

  getStars(): Observable<Star[]> {  
    return this.http.get<Star[]>(this.BASE_URL + '/stars');
  }

  getStarBySAO(SAO: number): Observable<Star> {
    return this.http.get<Star>(this.BASE_URL + '/stars/' + SAO);
  }

  getStarByConstellation(cons: number): Observable<Star> {
    return this.http.get<Star>(this.BASE_URL + '/stars/constellation/' + cons);
  }

  getAstronomicalStarBySAO(SAO: number): Observable<StarAstronomical> {
    return this.http.get<StarAstronomical>(this.BASE_URL + '/stars/astronomical/' + SAO);
  }
  
}

