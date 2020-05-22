package vanessa.apps.NoteApp.dao;

import vanessa.apps.NoteApp.models.Notebook;

import java.util.List;

public interface INotebook {
    Notebook addNotebook(Notebook notebook);

    List<Notebook> selectAllNotebooks();

    boolean deleteNotebookBasedOnId(int notebookId);

    boolean updateNotebookBasedOnId(int notebookId, Notebook notebook);

}
