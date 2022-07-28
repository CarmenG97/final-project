import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AmateurRegisterComponent } from './components/amateur-register/amateur-register.component';
import { AmateurComponent } from './components/amateur-login/amateur.component';
import { ConstellationDetailsComponent } from './components/constellation-details/constellation-details.component';
import { ConstellationPageComponent } from './components/constellation-page/constellation-page.component';
import { EventsComponent } from './components/events/events.component';
import { HomeComponent } from './components/home/home.component';
import { StarDetailsComponent } from './components/star-details/star-details.component';
import { StarAstronomicalDetailsComponent } from './components/star-astronomical-details/star-astronomical-details.component';
import { ExplanationComponent } from './components/explanation/explanation.component';

const routes: Routes = [
{
  path: '',
  component: HomeComponent
},  
{
  path: 'explanation',
  component: ExplanationComponent
},
{
  path: 'constellations',
  component: ConstellationPageComponent
} ,
{
  path: 'constellations/:id',
  component: ConstellationDetailsComponent
},
{
  path: 'stars/:sao',
  component: StarDetailsComponent
},
{
  path: 'login',
  component: AmateurComponent
},
{
  path: 'register',
  component: AmateurRegisterComponent
},
{
  path: 'events',
  component: EventsComponent
},
{
  path:'stars/astronomical/:sao',
  component: StarAstronomicalDetailsComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
