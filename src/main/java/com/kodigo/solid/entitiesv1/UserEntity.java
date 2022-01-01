package com.kodigo.solid.entitiesv1;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

<<<<<<< HEAD:src/main/java/com/kodigo/solid/entitiesv1/UserEntity.java
public class UserEntity extends BaseEntity implements Serializable {

  @Getter private String name;
  @Getter private LocalDate birthday;
  @Getter private String phoneNumber;
  @Getter private String email;
  @Getter private String password;

  public UserEntity(
      int id, String name, LocalDate birthday, String phoneNumber, String email, String password) {
    super(id);
    this.name = name;
    this.birthday = birthday;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
  }

  @Override
  public String toString() {
    return "UserEntity{"
        + ", name='"
        + name
        + '\''
        + ", birthday="
        + birthday
        + ", phoneNumber='"
        + phoneNumber
        + '\''
        + ", email='"
        + email
        + '\''
        + ", password='"
        + password
        + '\''
        + '}';
  }
=======
@Data
@NoArgsConstructor
public class UserEntity {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String Username;
    private String name;
    private LocalDate birthday;
    private String phoneNumber;
    private String email;
    private String password;
    private int Role;

    public UserEntity(int id, String username, String name, LocalDate birthday, String phoneNumber, String email, String password, int role) {
        this.id = id;
        this.Username = username;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.Role = role;
    }

    @Override
    public String toString() {
        return "\nUsuario: "+ "nombre: " + name + '\'' + " fecha de nacimiento: " + birthday + " numero de telefono: " + phoneNumber + '\'' + " correo electronico: " + email ;
    }
>>>>>>> origin/Roxana:src/main/java/com/kodigo/solid/entities/UserEntity.java
}



