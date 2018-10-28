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

  constructor(private shopsService: ShopsService) {
    this.Math = Math;
  }

  ngOnInit() {
    this.getServices();
  }

  getServices(){
    this.shopsService.getShops(0).subscribe((data : [Shop[]]) => this.shops = data["content"]);
  }


}