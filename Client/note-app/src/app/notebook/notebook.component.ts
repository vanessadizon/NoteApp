import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { faChevronRight, faTimes } from '@fortawesome/free-solid-svg-icons';
import { Notebook } from './model/notebook';
import { ApiService } from '../shared/api.service';
import {Note} from "../note/model/Note";

@Component({
  selector: 'app-notebook',
  templateUrl: './notebook.component.html',
  styleUrls: ['./notebook.component.css']
})
export class NotebookComponent implements OnInit {
  @ViewChild('newNotebook') newNotebookRef: ElementRef;
  faChevronRight = faChevronRight;
  faTimes = faTimes;
  notebooks: Notebook[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.selectAllNotebooks();
    this.apiService.onSelectedNotebookChange(-1);
  }

  selectNotebook(notebookId: number) {
    this.apiService.onSelectedNotebookChange(notebookId);
  }

  addNewNotebook(): void {
    if(this.newNotebookRef.nativeElement.value != "") {
      const newNotebook: Notebook = {
        notebookId: null,
        notebookName: this.newNotebookRef.nativeElement.value
      };
      this.apiService.addNewNotebook(newNotebook).subscribe(
        res => {
          this.notebooks.push(res);
        },
        err => {
          alert("Error in adding new notebook");
        }
      );
      this.newNotebookRef.nativeElement.value = '';
    }
  }

  updateNotebook(notebookId:number, notebook: Notebook): void {
    if(notebook.notebookName != "") {
      this.apiService.updateNotebook(notebookId, notebook).subscribe(
        res => {
        },
        err => {
          alert("Error in adding new notebook");
        }
      );
    }
  }

  selectAllNotebooks(): void {
    this.apiService.selectAllNotebooks().subscribe(
      res => {
        this.notebooks = res;
      },
      err => {
        alert("Error in selecting all notebooks");
      }
    );
  }

  deleteNotebook(notebook: Notebook) {
    this.apiService.deleteNotebook(notebook.notebookId).subscribe(
      res => {
        location.reload();
      },
      error => {

      });
  }
}
