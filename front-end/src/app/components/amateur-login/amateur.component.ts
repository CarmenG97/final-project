import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormGroupDirective, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Amateur } from 'src/app/models/amateur.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-amateur',
  templateUrl: './amateur.component.html',
  styleUrls: ['./amateur.component.css']
})
export class AmateurComponent implements OnInit {

  loginForm: FormGroup;

  nameInput: FormControl;
  passwordInput: FormControl;

  constructor(
    private authService: AuthService,
    private router: Router
    ) { 

    this.nameInput = new FormControl('', Validators.required);
    this.passwordInput = new FormControl('', [Validators.required, Validators.minLength(6)]);

    this.loginForm = new FormGroup({
      name: this.nameInput,
      password: this.passwordInput,
    });
  }

  
  ngOnInit(): void {
  }

  login() {
    this.authService.login(this.loginForm.value.name, this.loginForm.value.password).subscribe(
      (amateur: Amateur) => {
        console.log('Login successful');
        console.log(amateur);

        // Store user in local storage to keep user logged in between page refreshes
        localStorage.removeItem('currentUser');
        localStorage.setItem('currentUser', JSON.stringify(amateur));

        // Redirect to home page
        this.router.navigate(['/events']);
      }
    );
  }



 
}
