import { Component, OnInit} from '@angular/core';
import { Person } from "../model/person";
import { PersonServiceService } from "../service/person-service.service";

@Component({
  selector: 'app-people-main',
  templateUrl: './people-main.component.html',
  styleUrls: ['./people-main.component.css']
})
export class PeopleMainComponent{

  constructor() { }

}
