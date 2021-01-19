import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-comunlogin',
  templateUrl: './app.comun-login.component.html',
})
export class AppComunLoginComponent {

  constructor(
      private router: Router
  ) {
      //super(messageService);
  }

  login(): void {
    console.log('Ingreso al login !!');
    this.router.navigate(['main']);
  }

}
