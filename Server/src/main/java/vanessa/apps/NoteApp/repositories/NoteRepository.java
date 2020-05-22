package vanessa.apps.NoteApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vanessa.apps.NoteApp.models.Note;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    @Query("SELECT n FROM Note n WHERE n.notebookId = :notebookId ")
    List<Note> findAllNotesBasedOnNotebookId(@Param("notebookId") int notebookId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Note n WHERE n.notebookId = :notebookId AND n.noteId = :noteId")
    int deleteByNotebookIdAndNoteId(@Param("notebookId") int notebookId, @Param("noteId") int noteId);

}
