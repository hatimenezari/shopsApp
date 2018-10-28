import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ShopsComponent} from './shops/shops.component';

const routes: Routes = [

  { path: 'shops', component: ShopsComponent },
  { path: '', component: ShopsComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})


export class AppRoutingModule {

}

