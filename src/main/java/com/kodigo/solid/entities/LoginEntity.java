package main.java.com.kodigo.solid.entities;
import com.kodigo.solid.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;

public class LoginEntity extends UserEntity {

    public List<UserEntity> users =  new ArrayList<>();
    public UserEntity user = new UserEntity();
    private boolean Verified;

    public LoginEntity()
    {

    }

    public void userLogin() {
    }
}
