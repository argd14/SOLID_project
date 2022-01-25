package com.kodigo.solid.fakeDB;

import com.kodigo.solid.entities.AppointmentEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FakeAppointmentDbTest {

    FakeAppointmentDb fakeAppointmentDb;
    List<AppointmentEntity> appointmentEntityList;

    @BeforeEach
    public void setup() {
        fakeAppointmentDb = new FakeAppointmentDb();
        appointmentEntityList = fakeAppointmentDb.appointmentDatabase();
    }

    @Test
    @DisplayName("Method paymentDatabase - Should return list of payments")
    void appointmentDatabase() {
        assertFalse(appointmentEntityList.isEmpty());
        assertEquals(4, appointmentEntityList.size());
    }
}