import { Component, OnInit } from '@angular/core';
import {Shop} from '../modelClasses/Shop';
import {ShopsService} from '../services/shops.service';

@Component({
  selector: 'app-liked-shops',
  templateUrl: './liked-shops.component.html',
  styleUrls: ['./liked-shops.component.css']
})
export class LikedShopsComponent implements OnInit {

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
    this.shopsService.getLikedShops(this.page -1).subscribe((data : [Shop[]]) => this.shops = data["content"]);
  }

  pageChange(page: number){
    this.page = page;
    this.getShops();
  }


}
