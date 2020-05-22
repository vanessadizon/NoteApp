package vanessa.apps.NoteApp.models;

import javax.persistence.*;

@Entity
@Table(name="notebooks")
public class Notebook {
    @Id
    @GeneratedValue
    private int notebookId;
    private String notebookName;

    public Notebook(){}

    public Notebook(String notebookName) {
        this.notebookName = notebookName;
    }

    public int getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(int notebookId) {
        this.notebookId = notebookId;
    }

    public String getNotebookName() {
        return notebookName;
    }

    public void setNotebookName(String notebookName) {
        this.notebookName = notebookName;
    }
}
