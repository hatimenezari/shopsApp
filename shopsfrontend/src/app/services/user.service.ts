import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../modelClasses/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  URL: string = "http://localhost:8080";
  loged: boolean = false;
  user:User;
  constructor(private http: HttpClient) { }

  login(credentials:User){
    return this.http.post(this.URL +"/signin", {
      email: credentials.email,
      password: credentials.password
    } );
  }

  signup(credentials:User){
    return this.http.post(this.URL +"/signup", {
      email: credentials.email,
      password: credentials.password
    } );
  }
}
