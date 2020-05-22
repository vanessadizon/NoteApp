import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { faTimes, faPlus } from '@fortawesome/free-solid-svg-icons';
import {ApiService} from "../shared/api.service";
import {Note} from "./model/Note";
import {of} from "rxjs";

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {
  @ViewChild('newNoteTitle') newNoteTitle: ElementRef;
  @ViewChild('newNoteContents') newNoteContents: ElementRef;
  notes: Note[] = [];
  selectedNotebook: number;
  faTimes = faTimes;
  faPlus = faPlus;
  searchValue: string;

  constructor(private apiService: ApiService) {
    this.apiService.selectedNotebookObservable.subscribe(
      res => {
          of(this.showSelectedNotebookNotes(res));
        },
        error => {
        }
    );
    this.apiService.searchValueObservable.subscribe(
      res => {
        this.searchValue = res;
      },
      error => {
      }
    );
  }

  ngOnInit(): void {
  }

  deleteNote(note: Note): void {
    this.apiService.deleteNote(note.notebookId, note.noteId).subscribe(
      res => {
        this.notes = this.notes.filter(n => n.noteId != note.noteId);
      },
      err => {
        alert("Error deleting a note.")
    });
  }

  updateNote(note: Note): void {
    this.apiService.updateNote(note).subscribe(
      res => {
        console.log("Updated note.");
      },
      err => {
        alert("Error updating a note.")
      }
    );
  }

  addNote(): void {
    let note: Note = {
      noteId: null,
      title: this.newNoteTitle.nativeElement.value,
      contents: this.newNoteContents.nativeElement.value,
      dateModified: null,
      notebookId: this.selectedNotebook
    }

    if(this.newNoteTitle.nativeElement.value != '') {
      this.apiService.addNote(note).subscribe(
        res => {
          this.notes.push(res);
        },
        err => {
          alert("Error adding a note.")
        });
      this.newNoteTitle.nativeElement.value = '';
      this.newNoteContents.nativeElement.value = '';
    }
  }

  showSelectedNotebookNotes(notebookId: number) {
    this.selectedNotebook = notebookId;
    this.apiService.selectAllNotesBasedOnNotebookId(notebookId).subscribe(
      res => {
        this.notes = res;
      },
      err => {

      })
  }
}
