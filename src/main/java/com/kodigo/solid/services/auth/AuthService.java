package main.java.com.kodigo.solid.services.auth;

import java.io.IOException;

public interface AuthService {
    void userLogin() throws IOException;

    void logout();

    void signUp();
}
