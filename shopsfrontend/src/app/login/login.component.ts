import { Component, OnInit } from '@angular/core';
import {User} from '../modelClasses/User';
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

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(f: NgForm){
    this.user = new User(0,f.value.email, f.value.password);
    this.userService.login(this.user).subscribe((response) => {
        this.userService.loged = true;
        this.userService.user = this.user;
      }
    );

  }


}
