package SemID.src.pagamento;

import java.math.BigDecimal;

//Classe de BAIXO nivel
public class PagSeguro {

    String cartao;

    public PagSeguro(String cartao){
        this.cartao = cartao;
    }

    public void pagar(BigDecimal valor){

        System.out.println("Pagamento no valor de " + valor +" reais no cartao " + this.cartao + " efetuado com sucesso");

    }
}
