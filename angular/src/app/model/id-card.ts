import {Person} from "./person";
import {IssuingAuthority} from "./issuing-authority";

export class IdCard {
  private _id:number
  private _cardId:String
  private _person:Person
  private _dateOfIssue:Date
  private _expiryDate:Date
  private _issuingAuthority: IssuingAuthority

  constructor (obj?: any) {
    this._id = (obj && obj._id);
    this._cardId = (obj && obj._cardId);
    this._person = (obj && obj._person);
    this._dateOfIssue = (obj && obj._dateOfIssue);
    this._expiryDate = (obj && obj._expiryDate);
    this._issuingAuthority = (obj && obj._issuingAuthority)
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get cardId(): String {
    return this._cardId;
  }

  set cardId(value: String) {
    this._cardId = value;
  }

  get person(): Person {
    return this._person;
  }

  set person(value: Person) {
    this._person = value;
  }

  get dateOfIssue(): Date {
    return this._dateOfIssue;
  }

  set dateOfIssue(value: Date) {
    this._dateOfIssue = value;
  }

  get expiryDate(): Date {
    return this._expiryDate;
  }

  set expiryDate(value: Date) {
    this._expiryDate = value;
  }

  get issuingAuthority(): IssuingAuthority {
    return this._issuingAuthority;
  }

  set issuingAuthority(value: IssuingAuthority) {
    this._issuingAuthority = value;
  }
}
