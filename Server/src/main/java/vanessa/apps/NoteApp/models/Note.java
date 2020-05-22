package vanessa.apps.NoteApp.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="notes")
public class Note {
	@Id
	@GeneratedValue
	@Column(name = "note_id")
	private int noteId;

	@NotBlank
	private String title;
	@Column(name = "contents")
	private String contents;
	@Column(name = "date_modified")
	private Date dateModified;

	@Column(name = "notebook_id")
	private int notebookId;

	public Note(){}

	public Note(String title,
				String contents,
				int notebookId) {
		this.title = title;
		this.contents = contents;
		this.notebookId = notebookId;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public int getNotebookId() {
		return notebookId;
	}

	public void setNotebookId(int notebookId) {
		this.notebookId = notebookId;
	}
}
