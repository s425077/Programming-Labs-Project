import { Component, OnInit } from '@angular/core';
import {Person} from "../../model/person";
import {PersonServiceService} from "../../service/person-service.service";

@Component({
  selector: 'app-people-add-delete',
  templateUrl: './people-add-delete.component.html',
  styleUrls: ['./people-add-delete.component.css']
})
export class PeopleAddDeleteComponent implements OnInit {

  people: Person[];
  person: Person;
  id: number;

  constructor(
    private personService :PersonServiceService) { }

  ngOnInit() {
  }

  public save() {
    console.log(this.person, 'save')
    this.people[0] = this.person
    this.personService.save(this.person)
  }

  public delete(id: number) {
    console.log(id, 'delete')
    this.personService.deletePerson(id).subscribe(res => {this.people = this.people.filter(el => el.id !== id)})
  }

}
