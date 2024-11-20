package rest;

import domains.createAccount.CreateAccount;
import domains.createAccount.CreateAccountService;
import domains.login.LoginService;
import domains.login.NotAuthorised;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Path("account")
@Consumes( "application/json")
@Produces( "application/json")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final CreateAccountService service;
    private final LoginService loginService;

    AccountController(CreateAccountService service, LoginService loginService) {
        this.service = service;
        this.loginService = loginService;
    }

    @POST
    public void createAccount(CreateAccount account) {
        service.createAccount(account);
    }

    @POST
    @Path("login/{userName}")
    public boolean login(@PathParam("userName") String username, String password) {
        try {
            return loginService.login(username, password);
        } catch (NotAuthorised e) {
            return false;
        }
    }
}
