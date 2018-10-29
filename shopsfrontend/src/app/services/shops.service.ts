import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShopsService {

  constructor(private http: HttpClient) { }

  getShops(page: number){
    return this.http.get("http://localhost:8080/shops?page="+ page + "&size=9" );
  }
}
