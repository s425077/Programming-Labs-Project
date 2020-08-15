import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { PeopleComponent } from './people/listing/people.component';
import { CitiesComponent } from './cities/cities.component';
import { IdcardsComponent } from './idcards/idcards.component';
import { AuthoritiesComponent } from './authorities/authorities.component';
import { AppRoutingModule } from "./app-routing.module";
import { PersonServiceService } from "./service/person-service.service";
import { HttpClientModule } from "@angular/common/http"
import { PeopleMainComponent } from './people/people-main.component';
import { HomepageComponent } from './homepage/homepage.component';
import { PeopleFindIdComponent } from './people/findId/people-find-id.component';
import { PeopleAddDeleteComponent } from './people/people-add-delete/people-add-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    PeopleComponent,
    CitiesComponent,
    IdcardsComponent,
    AuthoritiesComponent,
    PeopleMainComponent,
    HomepageComponent,
    PeopleFindIdComponent,
    PeopleAddDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [PersonServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
