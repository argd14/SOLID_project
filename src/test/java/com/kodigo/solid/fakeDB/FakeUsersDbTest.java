package com.kodigo.solid.fakeDB;

import com.kodigo.solid.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FakeUsersDbTest {

    FakeUsersDb fakeUsersDb;
    List<UserEntity> userEntityList;

    @BeforeEach
    public void setup() {
        fakeUsersDb = new FakeUsersDb();
        userEntityList = fakeUsersDb.userDatabase();
    }

    @Test
    @DisplayName("Method userDatabase - Should return list of users")
    void userDatabase() {
        assertFalse(userEntityList.isEmpty());
        assertEquals(4, userEntityList.size());
    }
}