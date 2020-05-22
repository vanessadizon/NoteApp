import { Pipe, PipeTransform } from '@angular/core';
import {Note} from "../note/model/Note";

@Pipe({
  name: 'searchFilter'
})
export class SearchFilterPipe implements PipeTransform {

  transform(notes: Note[], searchValue: string): Note[] {
    if(searchValue == undefined || searchValue === "") {
      return notes;
    }
    return notes.filter(n => n.title.toUpperCase().includes(searchValue.toUpperCase()) || n.contents.toUpperCase().includes(searchValue.toUpperCase()));
  }

}
