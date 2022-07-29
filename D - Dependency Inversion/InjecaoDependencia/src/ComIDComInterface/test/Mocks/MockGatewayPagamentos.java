package ComIDComInterface.test.Mocks;


import ComIDComInterface.src.pagamento.PagSeguro;
import ComIDComInterface.src.pagamento.interfaces.IGatewayPagamentos;

import java.math.BigDecimal;

// Criando mock da classe PagSeguro
public class MockGatewayPagamentos implements IGatewayPagamentos {

    @Override
    public void pagar(BigDecimal valor) {
    //Não precisamos adicioanar nada, ou simplesmente dar o retorno que precisarmos
    }
}
