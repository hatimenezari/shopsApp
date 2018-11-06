import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserService} from './user.service';

@Injectable({
  providedIn: 'root'
})
export class ShopsService {
  URL: string = "http://localhost:8080";

  constructor(private http: HttpClient, private userService: UserService) { }

  getShops(page: number){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.userService.user.email+
        ':' + this.userService.user.password) });
    return this.http.get(this.URL+"/shops?page="+ page + "&size=9" , {headers});
  }
}
