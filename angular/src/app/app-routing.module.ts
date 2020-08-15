import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PeopleComponent } from "./people/listing/people.component";
import {AppComponent} from "./app.component";
import {HomepageComponent} from "./homepage/homepage.component";
import {PeopleMainComponent} from "./people/people-main.component";
import {PeopleFindIdComponent} from "./people/findId/people-find-id.component";
import {PeopleAddDeleteComponent} from "./people/people-add-delete/people-add-delete.component";

const routes: Routes = [
  { path: 'people', component: PeopleMainComponent },
  { path: 'homepage', component: HomepageComponent},
  { path: 'people/list', component: PeopleFindIdComponent},
  { path: 'people/add_delete', component: PeopleAddDeleteComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
