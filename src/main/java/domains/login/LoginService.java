package domains.login;

public interface LoginService {

    boolean login(String username, String password) throws NotAuthorised;
}
