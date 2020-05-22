import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable, Subject} from 'rxjs';
import { Notebook } from '../notebook/model/notebook';
import {Note} from "../note/model/Note";
const httpOptions = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Origin':'*'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private BASE_URL = "http://localhost:8080";
  private GET_ACCOUNT_URL = `${this.BASE_URL}\\account\\190e60e7-fc28-43e5-91e3-0aa56ceb603f`;
  private UPDATE_ACCOUNT_URL = `${this.BASE_URL}\\account\\190e60e7-fc28-43e5-91e3-0aa56ceb603f`;
  private SELECT_ALL_NOTEBOOKS_URL = `${this.BASE_URL}\\notebooks\\all\\`;
  private ADD_NEW_NOTEBOOK_URL = `${this.BASE_URL}\\notebooks\\`;
  private DELETE_NOTEBOOK_URL = `${this.BASE_URL}\\notebooks\\`;
  private UPDATE_NOTEBOOK_URL = `${this.BASE_URL}\\notebooks\\`;
  private SELECT_ALL_NOTES_URL = `${this.BASE_URL}\\notes\\`;
  private DELETE_NOTE_URL = `${this.BASE_URL}\\notes\\delete?notebookId=`;
  private UPDATE_NOTE_URL = `${this.BASE_URL}\\notes\\`;
  private ADD_NOTE_URL = `${this.BASE_URL}\\notes\\`;
  private SELECT_NOTES_BASED_ON_NOTEBOOK_ID = `${this.BASE_URL}\\notes\\`;

  selectedNotebook = new Subject<number>();
  selectedNotebookObservable = this.selectedNotebook.asObservable();
  searchValue = new Subject<string>();
  searchValueObservable = this.searchValue.asObservable();

  onSelectedNotebookChange(data: number) {
    this.selectedNotebook.next(data);
  }

  onSearchValueChange(data: string) {
    this.searchValue.next(data);
  }

  constructor(private http: HttpClient) { }

  //Account Settings
  getAccountDetails(): Observable<any> {
      return this.http.get(this.GET_ACCOUNT_URL, httpOptions);
  }

  updateAccountDetails(account: Account): Observable<any> {
      return this.http.put(this.UPDATE_ACCOUNT_URL, account, httpOptions);
  }

  // Notebook Settings
  selectAllNotebooks(): Observable<any> {
      return this.http.get(this.SELECT_ALL_NOTEBOOKS_URL);
  }

  addNewNotebook(notebook: Notebook): Observable<any> {
      return this.http.post(this.ADD_NEW_NOTEBOOK_URL, notebook, httpOptions);
  }

  updateNotebook(notebookId: number, notebook: Notebook): Observable<any> {
    return this.http.put(this.UPDATE_NOTEBOOK_URL + notebookId, notebook, httpOptions);
  }

  deleteNotebook(notebookId: number): Observable<any> {
    return this.http.delete(this.DELETE_NOTEBOOK_URL + notebookId, httpOptions);
  }

  // Note Settings
  deleteNote(notebookId: number, noteId:number): Observable<any> {
    return this.http.delete(this.DELETE_NOTE_URL+notebookId + "&noteId=" + noteId, httpOptions);
  }

  updateNote(note:Note): Observable<any> {
    return this.http.put(this.UPDATE_NOTE_URL, note, httpOptions);
  }

  addNote(note:Note): Observable<Note> {
    return this.http.post<Note>(this.ADD_NOTE_URL, note, httpOptions);
  }

  selectAllNotesBasedOnNotebookId(notebookId: number): Observable<Note[]> {
    return this.http.get<Note[]>(this.SELECT_NOTES_BASED_ON_NOTEBOOK_ID+notebookId, httpOptions);
  }
}
