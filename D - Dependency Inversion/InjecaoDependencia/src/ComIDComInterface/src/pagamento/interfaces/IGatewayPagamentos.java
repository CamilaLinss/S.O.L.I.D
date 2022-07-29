package ComIDComInterface.src.pagamento.interfaces;

import java.math.BigDecimal;

public interface IGatewayPagamentos {
    void pagar(BigDecimal valor); //Metodo que tanto a pagseguro quanto o paypal tem
}
