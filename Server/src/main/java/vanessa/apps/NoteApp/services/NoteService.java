package vanessa.apps.NoteApp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vanessa.apps.NoteApp.dao.INote;
import vanessa.apps.NoteApp.models.Note;
import vanessa.apps.NoteApp.repositories.NoteRepository;

import java.util.*;

@Service
public class NoteService implements INote {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note addNote(Note note) {
        note.setDateModified(new Date());
        this.noteRepository.save(note);
        return note;
    }

    public int deleteNoteBasedOnNoteId(int notebookId, int noteId) {
        return this.noteRepository.deleteByNotebookIdAndNoteId(notebookId, noteId);
    }

    public boolean updateNoteBasedOnNoteId(Note note) {
        int noteId = note.getNoteId();
        Note newNote = this.noteRepository.findById(noteId).get();
        newNote.setContents(note.getContents());
        newNote.setTitle(note.getTitle());
        newNote.setContents(note.getContents());
        newNote.setNotebookId(note.getNotebookId());
        newNote.setDateModified(new Date());
        this.noteRepository.save(newNote);
        return true;
    }

    public List<Note> selectAllNotesBasedOnNotebookId(int notebookId) {
        if(notebookId == -1) {
            return this.noteRepository.findAll();
        }
        return this.noteRepository.findAllNotesBasedOnNotebookId(notebookId);
    }
}
