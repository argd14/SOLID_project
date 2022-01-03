package com.kodigo.solid;


import com.kodigo.solid.services.auth.AuthServiceImplementation;

public class Main {

  public static void main(String[] args) {
    AuthServiceImplementation login = new AuthServiceImplementation();
    login.userLogin();
  }
}
