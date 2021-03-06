import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {UserService} from './user.service';
import {Shop} from '../modelClasses/Shop';

@Injectable({
  providedIn: 'root'
})
export class ShopsService {
  URL: string = "http://localhost:8080";

  constructor(private http: HttpClient, private userService: UserService) { }

  getShops(page: number){
    let headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.userService.user.email+
        ':' + this.userService.user.password) });
    headers = headers.append('Location', btoa(""+this.userService.user.coordinates.x +
      ":" + this.userService.user.coordinates.y));
    return this.http.get(this.URL+"/nearShops?page="+ page + "&size=8" , {headers});
  }

  getLikedShops(page: number){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.userService.user.email+
        ':' + this.userService.user.password) });
    return this.http.get(this.URL+"/likedShops?page="+ page + "&size=8" , {headers});
  }

  addLikedShop(s: Shop){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.userService.user.email+
        ':' + this.userService.user.password) });
    return this.http.post(this.URL + "/addLikedShop",s, {headers})
  }

  addDislikedShop(s: Shop){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.userService.user.email+
        ':' + this.userService.user.password) });
    return this.http.post(this.URL + "/addDisikedShop",s, {headers})
  }

  removeLikedShop(s:Shop){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.userService.user.email+
        ':' + this.userService.user.password) });
    return this.http.delete(this.URL + "/removeLikedShop/" + s.id, {headers});
  }
}
