import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Amateur } from 'src/app/models/amateur.model';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { CustomValidators } from '../utils/custom.validations';

@Component({
  selector: 'app-amateur-register',
  templateUrl: './amateur-register.component.html',
  styleUrls: ['./amateur-register.component.css']
})
export class AmateurRegisterComponent implements OnInit {

  registerForm: FormGroup;

  id: number;

  nameInput: FormControl;
  emailInput: FormControl;
  yearsInput: FormControl;
  passwordInput: FormControl;
  passwordConfirmationInput: FormControl;
  photoInput: FormControl;
  
  constructor(
    private authService: AuthService,
    private router: Router
    ) { 
    this.nameInput = new FormControl('', Validators.required);
    this.emailInput = new FormControl('', Validators.required);
    this.yearsInput = new FormControl;
    this.passwordInput = new FormControl('', [Validators.required, Validators.minLength(6)]);
    this.passwordConfirmationInput = new FormControl('', [Validators.required]);
    this.photoInput = new FormControl('');

    this.registerForm = new FormGroup({
      name: this.nameInput,
      email: this.emailInput,
      yearsOfExperience: this.yearsInput,
      password: this.passwordInput,
      passwordConfirmation: this.passwordConfirmationInput,
      photo: this.photoInput
    }, [CustomValidators.passwordMatch]);

    this.id = 0;
  }

  ngOnInit(): void {
  }

  register() {
    this.authService.register(this.registerForm.value.name, this.registerForm.value.email, this.registerForm.value.password, this.registerForm.value.yearsOfExperience, this.registerForm.value.photo).subscribe(
      (amateur: Amateur) => {
        alert('Register successful');
        console.log(amateur);

        // Redirect to home page
        this.router.navigate(['/login']);
      },
      (error) => {
        alert('Register failed');
        console.log(error);
      }
    );
  }

}
