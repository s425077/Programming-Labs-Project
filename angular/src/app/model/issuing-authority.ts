import {City} from "./city";
import {IdCard} from "./id-card";

export class IssuingAuthority {
  private _id:number
  private _name:String
  private _city:City[]
  private _idCards:IdCard[]

  constructor (obj?: any) {
    this._id = (obj && obj._id);
    this._name = (obj && obj._name);
    this._city = (obj && obj._city);
    this._idCards = (obj && obj._idCards);
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

  get city(): City[] {
    return this._city;
  }

  set city(value: City[]) {
    this._city = value;
  }

  get idCards(): IdCard[] {
    return this._idCards;
  }

  set idCards(value: IdCard[]) {
    this._idCards = value;
  }
}
