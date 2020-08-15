import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http'
import { Observable } from 'rxjs/Observable';
import { Person } from "../model/person";
import {City} from "../model/city";

const apiUrl: string = 'http://localhost:8080/app/people';


@Injectable()
export class PersonServiceService {

  constructor(private http: HttpClient) {}

  public findAllPeople(): Observable<Person[]> {
    return this.http.get<Person[]>(`${apiUrl}`);
  }

  public findAllPeoplePageable(page:number, pageSize:number): Observable<Person[]> {
    if (!pageSize || pageSize == 0)
      pageSize = 5;
    return this.http.get<Person[]>(`${apiUrl}/page/${page}?pageSize=${pageSize}`)
  }

  public listPeopleByCity(city:City): Observable<City[]> {
    return this.http.get<City[]>(`${apiUrl}/city/${city}`)
  }

  public findPersonByPesel(pesel: string): Observable<Person> {
    return this.http.get<Person>(`${apiUrl}/pesel/${pesel}`)
  }

  public findPersonById(id: number): Observable<Person> {
    return this.http.get<Person>(`${apiUrl}/id/${id}`)
  }

  public save(person: Person) {
    return this.http.post<Person>(apiUrl, person)
  }

  public deletePerson(id: number) {
    return this.http.delete(`${apiUrl}/${id}`)
  }

  public deletePersonByPesel(pesel: String) {
    return this.http.delete(`${apiUrl}/pesel/${pesel}`)
  }

}
