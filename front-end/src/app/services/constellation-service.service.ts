import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Constellation } from '../models/constellation.model';

@Injectable({
  providedIn: 'root'
})
export class ConstellationServiceService {

  private readonly BASE_URL='http://localhost:8080';
  constructor(
    private http: HttpClient,
  ) { }

  getConstellations(): Observable<Constellation[]> {
    return this.http.get<Constellation[]>(this.BASE_URL + '/constellations');
  }
  
  getConstellationById(id: number): Observable<Constellation> {
    return this.http.get<Constellation>(this.BASE_URL + '/constellations/' + id);
  }
}   
