import { Component, OnInit } from '@angular/core';
import { Person } from "../../model/person";
import { PersonServiceService } from "../../service/person-service.service";

@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.css']
})

export class PeopleComponent implements OnInit {

  people: Person[];

  constructor(private personService :PersonServiceService ) { }

  ngOnInit() {
    this.listAllPeople()
  }

  public listAllPeople() {
    this.personService.findAllPeople().subscribe(data => {this.people = data})
  }

  public findPersonByPesel(pesel: string) {
    this.personService.findPersonByPesel(pesel)
  }

  public save(person: Person) {
    console.log(person, 'save')
    this.personService.save(person)
  }

  public delete(id: number) {
    console.log(id, 'delete')
    this.personService.deletePerson(id).subscribe(res => {this.people = this.people.filter(el => el.id !== id)})
  }



}
