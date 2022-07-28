import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AmateurAttentEvent } from '../models/amateur-attend-event';

@Injectable({
  providedIn: 'root'
})
export class EventServiceService {
  [x: string]: any;

  private readonly BASE_URL='http://localhost:8080';
  constructor(
    private http: HttpClient,
  ) { }

  getEvents(): Observable<Event[]> {
    return this.http.get<Event[]>(this.BASE_URL + '/events');
  }

  getEventById(id: number): Observable<Event> {
    return this.http.get<Event>(this.BASE_URL + '/events/' + id);
  }

  getAllEventsOfAmateur(): Observable<AmateurAttentEvent[]> {
    return this.http.get<AmateurAttentEvent[]>(this.BASE_URL + '/events/amateur');
  }

  addEventToAmateur(amateurAttendEvent: AmateurAttentEvent): Observable<AmateurAttentEvent> {
    return this.http.post<AmateurAttentEvent>(this.BASE_URL + '/events/amateur', amateurAttendEvent);
  }
}
