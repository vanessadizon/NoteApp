package vanessa.apps.NoteApp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vanessa.apps.NoteApp.dao.IAccount;
import vanessa.apps.NoteApp.models.Account;
import vanessa.apps.NoteApp.repositories.AccountRepository;

import java.util.List;

@Service
public class AccountService implements IAccount {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccountDetails(String accountId) {
        return this.accountRepository.findById(accountId).get();
    }

    @Override
    public boolean updateAccountDetails(String accountId, Account account) {
        Account acc = this.accountRepository.findById(accountId).get();
        acc.setName(account.getName());
        acc.setDescription(account.getDescription());
        acc.setEmail(account.getEmail());
        acc.setPassword(account.getPassword());
        acc.setUsername(account.getUsername());
        this.accountRepository.save(acc);
        return true;
    }

    @Override
    public boolean changePassword(Account account) {
        return false;
    }
}
