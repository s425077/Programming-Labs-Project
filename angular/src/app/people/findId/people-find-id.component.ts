import { Component, OnInit, Inject } from '@angular/core';
import {Person} from "../../model/person";
import { DOCUMENT } from '@angular/common';
import {PersonServiceService} from "../../service/person-service.service";

@Component({
  selector: 'app-people-find-id',
  templateUrl: './people-find-id.component.html',
  styleUrls: ['./people-find-id.component.css']
})
export class PeopleFindIdComponent implements OnInit {

  people: Person[];
  person: Person;
  display: boolean;
  id: number;

  constructor(
    private personService :PersonServiceService,
    @Inject(DOCUMENT) private _document: Document
  ) { }

  ngOnInit() {
    //this.listAllPeople()
    this.display = false;
  }

  public listAllPeople() {
    this.personService.findAllPeople().subscribe(data => {this.people = data})
  }

  public async findPersonByPesel(pesel: string) {
    this.people = [];
    this.person = await this.personService.findPersonByPesel(pesel).toPromise()
    this.people[0] = this.person;
  }

  public async findPersonById(id: number) {
    this.people = [];
    this.person = await this.personService.findPersonById(id).toPromise()
    this.people[0] = this.person;
  }

  public save(person: Person) {
    console.log(person, 'save')
    this.personService.save(person)
  }

  public delete(id: number) {
    console.log(id, 'delete')
    this.personService.deletePerson(id).subscribe(res => {this.people = this.people.filter(el => el.id !== id)})
  }

  public switchDisplay() {
    this.display = !this.display;
  }

  public ifTrue() {
    return this.display;
  }

}
