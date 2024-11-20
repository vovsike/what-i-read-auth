package domains.login;

public class NotAuthorised extends Exception {
    public NotAuthorised(String message) {
        super(message);
    }
}
