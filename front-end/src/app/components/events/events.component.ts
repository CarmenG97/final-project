import { Component, OnInit } from '@angular/core';
import { Event } from 'src/app/models/event.model';
import { EventServiceService } from 'src/app/services/event-service.service';
import { AmateurAttentEvent } from 'src/app/models/amateur-attend-event';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  events: Event[];

  amateurId: number;

  amateurAttendEvent: AmateurAttentEvent | undefined;

  eventClicId: number;

  backgroundColor: string ="rgb(180, 177, 177)";
  color: string = "white";

  constructor(private eventService: EventServiceService) { 
    this.events = []; 

    this.amateurId = 0;
    this.eventClicId = 0;

  }

  ngOnInit(): void {
  this.getEvents();
  // localStorage.getItem('currentUser');
  this.amateurId = JSON.parse(localStorage.getItem('currentUser')as string).id as number;

  console.log(JSON.parse(localStorage.getItem('currentUser')as string));
  }

  getEvents(): void {
    this.eventService.getEvents().subscribe(
      (response: any) => {
        this.events = response;
        console.log(response);
      }
    );
  }

   overBox():void{
     if (this.backgroundColor==="rgb(180, 177, 177)"){
       this.backgroundColor="lightgray";
       this.color="white";
     } else if (this.backgroundColor==="lightgray"){
       this.backgroundColor="rgb(180, 177, 177)";
       this.color="white";
     }
  }

   participation(eventId: number): void {

      this.amateurAttendEvent = new AmateurAttentEvent(null, this.amateurId, eventId);
      console.log(this.amateurId);

      this.eventService.addEventToAmateur(this.amateurAttendEvent).subscribe(
       (response: any) => {
         console.log(response);
         this.eventClicId = response.eventId;
       }
     );

    
     
   }


}