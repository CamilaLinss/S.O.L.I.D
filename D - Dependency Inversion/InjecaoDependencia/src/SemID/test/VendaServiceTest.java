package SemID.test;

import SemID.src.venda.Mercadoria;
import SemID.src.venda.VendaService;
import org.junit.Test;

import java.math.BigDecimal;

public class VendaServiceTest {

    @Test
    public void registrarVenda(){

        // Nesse teste podemos observar que não mockei nada, estou chamando VendaService que esta chamando PagSeguro no contetxo real
        // portando toda vez que rodar esse teste, ele vai efetuar um pagamento de verdade, ou seja não é um teste unitario real

        // Em chamadas que a conexão falhe, ja que a chamada é real, o teste sempre vai falhar

        Mercadoria mercadoria = new Mercadoria();
        mercadoria.valor = new BigDecimal(134.78).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        mercadoria.Nome = "God of War";

        VendaService vendaService = new VendaService();
        vendaService.registrar(mercadoria);

    }
}
