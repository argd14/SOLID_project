package fkDatabase;

import com.kodigo.solid.controllers.PaymentEntityController;
import com.kodigo.solid.entities.PaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDataBase {
    private PaymentEntityController paymentData = new PaymentEntityController();

    public void dataBase(int idAuth) {
        PaymentEntity newPayment = new PaymentEntity(1, idAuth, "Pago de consulta", 15.00);
        paymentData.addPayment(newPayment);
        PaymentEntity newPayment2 = new PaymentEntity(2,idAuth, "Pago de receta", 25.00);
        paymentData.addPayment(newPayment2);
    }
}
