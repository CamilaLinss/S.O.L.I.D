package ComIDComInterface.src.pagamento;

import ComIDComInterface.src.pagamento.interfaces.IGatewayPagamentos;

import java.math.BigDecimal;


public class PagSeguro implements IGatewayPagamentos { //implementam a interface

    String cartao;

    public PagSeguro(String cartao){
        this.cartao = cartao;
    }

    @Override
    public void pagar(BigDecimal valor){

        System.out.println("[PagSeguro] Pagamento no valor de " + valor +" reais no cartao " + this.cartao + " efetuado com sucesso");

    }
}
