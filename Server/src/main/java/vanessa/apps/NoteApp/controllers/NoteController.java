package vanessa.apps.NoteApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vanessa.apps.NoteApp.models.Note;
import vanessa.apps.NoteApp.services.NoteService;

import java.util.List;
import java.util.UUID;

@RequestMapping("notes/")
@RestController
@CrossOrigin(origins = "*")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public Note addNote(@RequestBody Note note) {
        return noteService.addNote(note);
    }

    @PutMapping
    public boolean updateNoteBasedOnNoteId(@RequestBody Note note) {
        return this.noteService.updateNoteBasedOnNoteId(note);
    }

    @DeleteMapping(path = "delete")
    public int deleteNoteBasedOnNoteId(@RequestParam("notebookId") int notebookId, @RequestParam("noteId") int noteId) {
        return this.noteService.deleteNoteBasedOnNoteId(notebookId, noteId);
    }

    @GetMapping(path = "{notebookId}")
    public List<Note> selectAllNotesBasedOnNotebookId(@PathVariable("notebookId") int notebookId) {
        return this.noteService.selectAllNotesBasedOnNotebookId(notebookId);
    }
}
