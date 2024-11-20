package domains.account;

import java.util.Optional;

public interface AccountRepo {

    Optional<Account> findByUsername(String username);

    Account findByEmail(String email);

    void createAccount(Account account);

    Account updateAccount(Account account);
}
