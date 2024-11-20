package impl.login;

import domains.account.AccountRepo;
import domains.login.LoginService;
import domains.login.NotAuthorised;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoginServiceBasic implements LoginService {

    private final AccountRepo repo;

    LoginServiceBasic(AccountRepo repo) {
        this.repo = repo;
    }

    @Override
    public boolean login(String username, String password) throws NotAuthorised{
        var account = repo.findByUsername(username).orElseThrow(() -> new NotAuthorised("No account found"));
        return BcryptUtil.matches(password, account.getPassword());
    }
}
