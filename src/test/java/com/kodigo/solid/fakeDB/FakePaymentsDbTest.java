package com.kodigo.solid.fakeDB;

import com.kodigo.solid.entities.PaymentEntity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FakePaymentsDbTest {

    FakePaymentsDb fakePaymentsDb;
    List<PaymentEntity> paymentEntityList;

    @BeforeEach
    public void setup() {
        fakePaymentsDb = new FakePaymentsDb();
        paymentEntityList = fakePaymentsDb.paymentDatabase();
    }

    @Test
    @DisplayName("Method paymentDatabase - Should return list of payments")
    void paymentDatabase() {
        assertFalse(paymentEntityList.isEmpty());
        assertEquals(4, paymentEntityList.size());
    }
}