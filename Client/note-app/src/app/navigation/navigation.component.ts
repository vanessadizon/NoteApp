import { Component, OnInit } from '@angular/core';
import {ApiService} from "../shared/api.service";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  searchValue: string;
  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
  }

  searchNote() {
    this.apiService.onSearchValueChange(this.searchValue);
  }

}
