import {Coordinates} from '../modelClasses/Coordinates';
export class User{
  constructor(public id: number,public email: string, public password: string,public coordinates: Coordinates){

  }
}
