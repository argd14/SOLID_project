package com.kodigo.solid.fakeDB;

import com.kodigo.solid.entities.PrescriptionEntity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.kodigo.solid.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FakePrescriptionDbTest {

    FakePrescriptionDb fakePrescriptionDb;
    List<PrescriptionEntity> prescriptionEntityList;

    @BeforeEach
    public void setup() {
        fakePrescriptionDb = new FakePrescriptionDb();
        prescriptionEntityList = fakePrescriptionDb.prescriptiontDatabase();
    }

    @Test
    @DisplayName("Method prescriptiontDatabase - Should return list of prescriptions")
    void prescriptiontDatabase() {
        assertFalse(prescriptionEntityList.isEmpty());
        assertEquals(4, prescriptionEntityList.size());
    }


}