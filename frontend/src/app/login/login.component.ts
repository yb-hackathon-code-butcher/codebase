import {Component, OnInit} from '@angular/core';
import {LoginModel} from "../../model/rest/login/login.model";
import {AuthService} from "../../services/common/auth.service";
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginModel: LoginModel = <LoginModel>{};

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    if(this.authService.isAuthenticated()){
      this.router.navigateByUrl('team-selection')
    }
  }

  guestLogin() {
    this.authService.guestLogin(this.authService.getUUID()).subscribe((response) =>{
      console.log(response);
    });
  }
}
