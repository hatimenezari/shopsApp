import { Component, OnInit } from '@angular/core';
import {Shop} from '../modelClasses/Shop';
import {ShopsService} from '../services/shops.service';

@Component({
  selector: 'app-shops',
  templateUrl: './shops.component.html',
  styleUrls: ['./shops.component.css']
})

export class ShopsComponent implements OnInit {

  shops: Shop[];
  Math: any;
  page: number = 1;

  constructor(private shopsService: ShopsService) {
    this.Math = Math;
  }

  ngOnInit() {
    this.getShops();
  }

  getShops(){
    this.shopsService.getShops(this.page -1).subscribe((data : [Shop[]]) => this.shops = data["content"]);
  }

  pageChange(page: number){
    this.page = page;
    this.getShops();
  }

  addLikedShop(s: Shop){
    this.shopsService.addLikedShop(s).subscribe(()=> this.getShops());
  }

  addDisikedShop(s: Shop){
    this.shopsService.addDislikedShop(s).subscribe(()=> this.getShops());
  }
}
