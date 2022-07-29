package ComIDSemInterface.test;

import ComIDSemInterface.src.venda.Mercadoria;
import ComIDSemInterface.src.venda.VendaService;
import ComIDSemInterface.test.Mocks.MockPagSeguro;
import org.junit.Test;

import java.math.BigDecimal;

public class VendaServiceTest {

    @Test
    public void registrarVenda(){

        // Essa mudança ja vai facilitar mais para os testes unitarios, ja que o tipo PagSeguro esperado
        // pode receber varias formas de si mesmo, ou seja vamos usar polimorfismo

        // Criamos uma classe de mock que herda da classe PagSeguro (nossa dependencia), logo ela é aceita
        // como um objeto da PagSeguro
        MockPagSeguro mockPagSeguro = new MockPagSeguro(new String());

        Mercadoria mercadoria = new Mercadoria();
        mercadoria.valor = new BigDecimal(134.78).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        mercadoria.Nome = "God of War";

        //Agora ele vai pra classe e metodo mockado e não mais para o real
        VendaService vendaService = new VendaService(mockPagSeguro);
        vendaService.registrar(mercadoria);

    }
}
