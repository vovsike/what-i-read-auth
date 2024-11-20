package impl.account;

import domains.account.Account;
import domains.account.AccountRepo;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AccountRepoStud implements AccountRepo {

    private final List<Account> accounts = new ArrayList<>();


    @Override
    public Optional<Account> findByUsername(String username) {
        return accounts.stream().filter(account -> account.getUsername().equals(username)).findFirst();
    }

    @Override
    public Account findByEmail(String email) {
        return accounts.stream().filter(account -> account.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public void createAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public Account updateAccount(Account account) {
        var index = accounts.indexOf(account);
        if (index != -1) {
            accounts.set(index, account);
            return account;
        }
        return null;
    }
}
