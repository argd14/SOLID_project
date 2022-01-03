package com.kodigo.solid;


import com.kodigo.solid.services.auth.AuthServiceImplementation;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AuthServiceImplementation login = new AuthServiceImplementation();
        login.userLogin();
    }
}
