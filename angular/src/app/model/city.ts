import {Person} from "./person";
import {IssuingAuthority} from "./issuing-authority";

export class City {
  private _id: number
  private _name: String
  private _country: String
  private _region: String
  private _postalCode: String
  private _registeredPeople: Person[]
  private _issuingAuthority: IssuingAuthority

  constructor (obj?: any) {
    this._id = (obj && obj._id);
    this._name = (obj && obj._name);
    this._country = (obj && obj._country);
    this._region = (obj && obj._region);
    this._postalCode = (obj && obj._postalCode);
    this._registeredPeople = (obj && obj._registeredPeople);
    this._issuingAuthority = (obj && obj._issuingAuthority);
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): String {
    return this._name;
  }

  set name(value: String) {
    this._name = value;
  }

  get country(): String {
    return this._country;
  }

  set country(value: String) {
    this._country = value;
  }

  get region(): String {
    return this._region;
  }

  set region(value: String) {
    this._region = value;
  }

  get postalCode(): String {
    return this._postalCode;
  }

  set postalCode(value: String) {
    this._postalCode = value;
  }

  get registeredPeople(): Person[] {
    return this._registeredPeople;
  }

  set registeredPeople(value: Person[]) {
    this._registeredPeople = value;
  }

  get issuingAuthority(): IssuingAuthority {
    return this._issuingAuthority;
  }

  set issuingAuthority(value: IssuingAuthority) {
    this._issuingAuthority = value;
  }
}
