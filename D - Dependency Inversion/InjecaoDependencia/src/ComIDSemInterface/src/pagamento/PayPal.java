package ComIDSemInterface.src.pagamento;

import java.math.BigDecimal;

public class PayPal {

    String cartao;

    public PayPal(String cartao){
        this.cartao = cartao;
    }

    public void pagar(BigDecimal valor){

        System.out.println("[PayPal] Pagamento no valor de " + valor +" reais no cartao " + this.cartao + " efetuado com sucesso");

    }
}
