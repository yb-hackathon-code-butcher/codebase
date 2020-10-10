import {Component, OnInit} from '@angular/core';
import {LoginModel} from "../../model/rest/login/login.model";
import {LoginService} from "../../services/rest/login/login.service";
import {AuthService} from "../../services/common/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginModel: LoginModel = <LoginModel>{};

  constructor(private loginService: LoginService, private authService: AuthService) { }

  ngOnInit(): void {
  }


  guestLogin() {
    if(!this.authService.isAuthenticated()){
      this.loginService.guestLogin(this.authService.getUUID()).subscribe((response) =>{
        console.log(response);
      });
    }
  }

  login() {
    this.loginService.login(this.loginModel).subscribe((response) =>{
      console.log(response);
    });
  }

  register() {
    this.loginService.register(this.loginModel).subscribe((response) =>{
      console.log(response);
    });
  }
}
