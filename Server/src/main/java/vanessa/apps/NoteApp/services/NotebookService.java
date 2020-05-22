package vanessa.apps.NoteApp.services;
import vanessa.apps.NoteApp.dao.INotebook;
import vanessa.apps.NoteApp.models.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vanessa.apps.NoteApp.repositories.NoteRepository;
import vanessa.apps.NoteApp.repositories.NotebookRepository;

import java.util.List;

@Service
public class NotebookService implements INotebook {
    private final NotebookRepository notebookRepository;

    @Autowired
    public NotebookService(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    public Notebook addNotebook(Notebook notebook) {
        return this.notebookRepository.save(notebook);
    }

    public List<Notebook> selectAllNotebooks() {
        return this.notebookRepository.findAll();
    }

    public boolean deleteNotebookBasedOnId(int notebookId) {
        this.notebookRepository.deleteById(notebookId);
        return true;
    }

    public boolean updateNotebookBasedOnId(int notebookId, Notebook notebook) {
        Notebook currentNotebook = this.notebookRepository.getOne(notebookId);
        currentNotebook.setNotebookName(notebook.getNotebookName());
        this.notebookRepository.save(currentNotebook);
        return true;
    }
}
