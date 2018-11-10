import { Component, OnInit } from '@angular/core';
import {User} from '../modelClasses/User';
import {Coordinates} from '../modelClasses/Coordinates';
import {NgForm} from '@angular/forms';
import {UserService} from '../services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:User;
  coordinates:Coordinates = new Coordinates(33.9716, 6.8498);

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {

  }

  onSubmit(f: NgForm){
    if(window.navigator.geolocation){
      window.navigator.geolocation.getCurrentPosition(position => {
        this.coordinates.x = position["coords"]["latitude"];
        this.coordinates.y = position["coords"]["longitude"];
      });
    }
    this.user = new User(0,f.value.email, f.value.password, this.coordinates);
    this.userService.login(this.user).subscribe((response) => {
        this.userService.loged = true;
        this.userService.user = this.user;
      }
    );

  }


}
