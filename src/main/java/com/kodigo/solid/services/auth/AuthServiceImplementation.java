package com.kodigo.solid.services.auth;

import com.kodigo.solid.data.repositories.DoctorRepository;

public class AuthServiceImplementation implements AuthService {
  private DoctorRepository doctorRepository;

  public AuthServiceImplementation(DoctorRepository doctorRepository) {
    this.doctorRepository = doctorRepository;
  }

  @Override
  public void login() {
    System.out.println("..User logging.");
  }

  @Override
  public void logout() {
    System.out.println("..User logout");
  }

  @Override
  public void signUp() {
    System.out.println("Welcome new user.");
  }
}
