import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TopBarComponent } from './components/header/header.component';
import { ConstellationDetailsComponent } from './components/constellation-details/constellation-details.component';
import { ExplanationComponent } from './components/explanation/explanation.component';
import { ConstellationPageComponent } from './components/constellation-page/constellation-page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { StarDetailsComponent } from './components/star-details/star-details.component';
import { AmateurComponent } from './components/amateur-login/amateur.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatButtonModule} from '@angular/material/button';
import { HomeComponent } from './components/home/home.component';
import { AmateurDetailsComponent } from './components/amateur-details/amateur-details.component';
import { EventsComponent } from './components/events/events.component';
import { AmateurRegisterComponent } from './components/amateur-register/amateur-register.component';
import { StarAstronomicalDetailsComponent } from './components/star-astronomical-details/star-astronomical-details.component';


@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    ConstellationDetailsComponent,
    ExplanationComponent,
    ConstellationPageComponent,
    NavBarComponent,
    StarDetailsComponent,
    AmateurComponent,
    HomeComponent,
    AmateurDetailsComponent,
    EventsComponent,
    AmateurRegisterComponent,
    StarAstronomicalDetailsComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatButtonModule,
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
