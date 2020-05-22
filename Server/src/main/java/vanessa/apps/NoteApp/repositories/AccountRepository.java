package vanessa.apps.NoteApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vanessa.apps.NoteApp.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
