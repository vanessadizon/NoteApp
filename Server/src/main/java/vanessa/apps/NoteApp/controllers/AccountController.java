package vanessa.apps.NoteApp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vanessa.apps.NoteApp.models.Account;
import vanessa.apps.NoteApp.services.AccountService;

@RequestMapping("account/")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path="{accountId}")
    public Account getAccountDetails(@PathVariable("accountId") String accountId) {
        return accountService.getAccountDetails(accountId);
    }

    @PutMapping(path="{accountId}")
    public boolean updateAccountDetails(@PathVariable("accountId") String accountId, @RequestBody Account account) {
        return accountService.updateAccountDetails(accountId, account);
    }

    @PostMapping(path="changePass")
    public boolean changePassword(@RequestBody Account account){
        return accountService.changePassword(account);
    }

}
