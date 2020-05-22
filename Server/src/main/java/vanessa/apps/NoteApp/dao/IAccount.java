package vanessa.apps.NoteApp.dao;

import org.springframework.data.jpa.repository.Query;
import vanessa.apps.NoteApp.models.Account;

public interface IAccount {
    Account getAccountDetails(String accountId);
    boolean updateAccountDetails(String accountId, Account account);
    boolean changePassword(Account account);

}
