package ComIDComInterface.test;

import ComIDComInterface.src.venda.Mercadoria;
import ComIDComInterface.src.venda.VendaService;
import ComIDComInterface.test.Mocks.MockGatewayPagamentos;
import org.junit.Test;

import java.math.BigDecimal;

public class VendaServiceTest {

    @Test
    public void registrarVenda(){

        // Agora conseguimos mockar todas as classes que implementam a interface e de forma mais facil e abstrata
        //MockPagSeguro mockPagSeguro = new MockPagSeguro(new String());

        Mercadoria mercadoria = new Mercadoria();
        mercadoria.valor = new BigDecimal(134.78).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        mercadoria.Nome = "God of War";

        VendaService vendaService = new VendaService(new MockGatewayPagamentos());
        vendaService.registrar(mercadoria);

    }
}
