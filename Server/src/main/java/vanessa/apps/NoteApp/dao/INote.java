package vanessa.apps.NoteApp.dao;

import vanessa.apps.NoteApp.models.Note;

import java.util.List;

public interface INote {
    Note addNote(Note note);

    int deleteNoteBasedOnNoteId(int notebookId, int noteId);

    boolean updateNoteBasedOnNoteId(Note note);

    List<Note> selectAllNotesBasedOnNotebookId(int notebookId);
}
