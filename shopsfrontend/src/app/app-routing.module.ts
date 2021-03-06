import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ShopsComponent} from './shops/shops.component';
import {LoginComponent} from './login/login.component';
import {LikedShopsComponent} from './liked-shops/liked-shops.component';

const routes: Routes = [

  { path: 'shops', component: ShopsComponent },
  { path: 'signin', component: LoginComponent },
  { path: 'likedShops', component: LikedShopsComponent },
  { path: '', component: LoginComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})


export class AppRoutingModule {

}

