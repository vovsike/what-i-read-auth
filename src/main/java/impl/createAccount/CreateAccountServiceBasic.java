package impl.createAccount;

import domains.account.Account;
import domains.account.AccountRepo;
import domains.createAccount.CreateAccount;
import domains.createAccount.CreateAccountService;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateAccountServiceBasic implements CreateAccountService {

    private final AccountRepo repo;

    CreateAccountServiceBasic(AccountRepo repo) {
        this.repo = repo;
    }

    @Override
    public Account createAccount(CreateAccount accountToCreate) {
        hashAccountPassword(accountToCreate);
        repo.createAccount(accountToCreate);
        return accountToCreate;
    }

    private void hashAccountPassword(CreateAccount createAccount) {
        String passwordHash = BcryptUtil.bcryptHash(createAccount.getPassword());
        createAccount.setPassword(passwordHash);
    }
}
