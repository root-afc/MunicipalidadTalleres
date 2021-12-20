import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {LoginService} from './login.service';
import {NgxSpinnerService} from 'ngx-spinner';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {
  badLogin = false;
  hide = true;
  fgLogin: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder, private loginService: LoginService, private spinner: NgxSpinnerService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.newFgLogin();
  }

  newFgLogin(): void {
    this.fgLogin = this.fb.group({
      usuario: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  async login(): Promise<any> {
    this.fgLogin.markAllAsTouched();
    if (this.fgLogin.valid) {
      const user = this.fgLogin.controls.usuario.value;
      const pwd = this.fgLogin.controls.password.value;
      const credentials = {username: user, password: pwd};
      this.spinner.show();
      await this.loginService.loginJWT(credentials).toPromise()
        .then(res => {
          localStorage.setItem('id_user', res.id);
          localStorage.setItem('auth_token', res.jwt);
          localStorage.setItem('role', res.role[0].roleName);
          if (res.role[0].roleName === 'ADMIN') {
            this.badLogin = false;
            this.router.navigateByUrl('/administrador/ver');
          } else {
            this.badLogin = true;
          }
        })
        .catch(() => this.badLogin = true);
      this.spinner.hide();
    }
  }
}
