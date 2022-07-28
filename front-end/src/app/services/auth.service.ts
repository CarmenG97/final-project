import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Amateur } from '../models/amateur.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  readonly BASE_URL = 'http://localhost:8080';

  constructor(
    private http: HttpClient
  ) { }

  isAuthenticated(): boolean {
    const token: string | null = localStorage.getItem('currentUser');
    return token !== null;
  }

  register(
    name: string,
    email: string,
    password: string,
    yearsOfExperience: number,
    photo: string): Observable<Amateur> {

    const amateur: Amateur = new Amateur(
      null,
      name,
      email,
      yearsOfExperience,
      password,
      photo,
    );

    return this.http.post<Amateur>(`${this.BASE_URL}/amateurs`, amateur);
          
  }

  login(name: string, password: string): Observable<Amateur> {
    let headers = new HttpHeaders();
    headers = headers.append('Authorization', 'Basic ' + btoa(`${name}:${password}`));

    return this.http.get<Amateur>(`${this.BASE_URL}/login`, { headers: headers });
        
}

logout(): void {
    // Remove user from local storage to log user out
    localStorage.removeItem('currentUser');
}

getAmateurs(): Observable<Amateur[]> {
  return this.http.get<Amateur[]>(this.BASE_URL + '/amateurs');
}

getAmateurById(id: number): Observable<Amateur> {
  return this.http.get<Amateur>(this.BASE_URL + '/amateurs/' + id);
}

}