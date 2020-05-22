package vanessa.apps.NoteApp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vanessa.apps.NoteApp.models.Note;
import vanessa.apps.NoteApp.models.Notebook;
import vanessa.apps.NoteApp.services.NotebookService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@RequestMapping("notebooks/")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotebookController {
    private final NotebookService notebookService;

    @Autowired
    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @PostMapping
    public Notebook addNotebook(@RequestBody Notebook notebook) {
        return notebookService.addNotebook(notebook);
    }

    @GetMapping(path ="all")
    public List<Notebook> selectAllNotebooks() {
        return notebookService.selectAllNotebooks();
    }

    @DeleteMapping(path = "{id}")
    public void deleteNotebookBasedOnId(@PathVariable("id") int notebookId) {
        notebookService.deleteNotebookBasedOnId(notebookId);
    }

    @PutMapping(path = "{id}")
    public boolean updateNotebookBasedOnId(@PathVariable("id") int notebookId,@Valid @NotBlank @RequestBody Notebook notebook) {
        return notebookService.updateNotebookBasedOnId(notebookId, notebook);
    }
}
