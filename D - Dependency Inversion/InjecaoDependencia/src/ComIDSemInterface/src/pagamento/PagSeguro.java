package ComIDSemInterface.src.pagamento;

import java.math.BigDecimal;


public class PagSeguro {

    String cartao;

    public PagSeguro(String cartao){
        this.cartao = cartao;
    }

    public void pagar(BigDecimal valor){

        System.out.println("[PagSeguro] Pagamento no valor de " + valor +" reais no cartao " + this.cartao + " efetuado com sucesso");

    }
}
