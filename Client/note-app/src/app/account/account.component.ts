import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { ApiService} from '../shared/api.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  constructor(private apiService: ApiService, private fb : FormBuilder) { }

  ngOnInit(): void {
    this.getAccountDetails();
  }

  accountForm = this.fb.group({
        id: new FormControl(),
        name: new FormControl(['',Validators.required]),
        email: new FormControl(['', Validators.email]),
        description: new FormControl(''),
        username: new FormControl(Validators.required),
        password: new FormControl()
      });

  getAccountDetails():void {
    this.apiService.getAccountDetails().subscribe(
      res => {
        this.accountForm.setValue(res);
      },
      err => {
        alert("Getting account details failed.");
      });
  }

  updateAccountDetails():void {
    this.apiService.updateAccountDetails(this.accountForm.value).subscribe(
      res => {
        alert("Updated.");
      },
      err => {
        alert("Updating account details failed.");
      });
  }

}
