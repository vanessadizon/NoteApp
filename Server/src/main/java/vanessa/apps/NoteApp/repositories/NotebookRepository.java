package vanessa.apps.NoteApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vanessa.apps.NoteApp.models.Notebook;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Integer> {
}
