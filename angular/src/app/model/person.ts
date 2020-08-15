import {City} from "./city";
import {IdCard} from "./id-card";

export class Person {
    private _id: number
    private _pesel: string
    private _firstName: string
    private _lastName: string
    private _fatherName: string
    private _motherName: string
    private _birthdate: Date
    private _birthplace: City
    private _idCard: IdCard

  constructor (obj?: any) {
  this._id = (obj && obj.id);
  this._pesel = (obj && obj._pesel);
  this._firstName = (obj && obj._firstName);
  this._lastName = (obj && obj._lastName);
  this._fatherName = (obj && obj._fatherName);
  this._motherName = (obj && obj._motherName);
  this._birthdate = (obj && obj._birthdate);
  this._birthplace = (obj && obj._birthplace);
  this._idCard = (obj && obj._idCard);
}

  public get id(): number {
    return this._id;
  }

  public set id(value: number) {
    this._id = value;
  }

  get pesel(): string {
    return this._pesel;
  }

  set pesel(value: string) {
    this._pesel = value;
  }

  get firstName(): string {
    return this._firstName;
  }

  set firstName(value: string) {
    this._firstName = value;
  }

  get lastName(): string {
    return this._lastName;
  }

  set lastName(value: string) {
    this._lastName = value;
  }

  get fatherName(): string {
    return this._fatherName;
  }

  set fatherName(value: string) {
    this._fatherName = value;
  }

  get motherName(): string {
    return this._motherName;
  }

  set motherName(value: string) {
    this._motherName = value;
  }

  get birthdate(): Date {
    return this._birthdate;
  }

  set birthdate(value: Date) {
    this._birthdate = value;
  }

  get birthplace(): City {
    return this._birthplace;
  }

  set birthplace(value: City) {
    this._birthplace = value;
  }

  get idCard(): IdCard {
    return this._idCard;
  }

  set idCard(value: IdCard) {
    this._idCard = value;
  }

}
