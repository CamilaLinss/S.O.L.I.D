package ComIDSemInterface.test.Mocks;


import ComIDSemInterface.src.pagamento.PagSeguro;

import java.math.BigDecimal;

// Criando mock da classe PagSeguro
public class MockPagSeguro extends PagSeguro {

    public MockPagSeguro(String cartao){
        super(cartao); // passo um numero de cartão mas ele não vai fazer nada com essa informação
    }

    //Sobreescrevo o metodo pagar
    @Override
    public void pagar(BigDecimal valor) {
       System.out.println("[Mock] Não faz nada");
       //Nessa mesma logica poderiamos mockar metodos com retornos, onde poderia colocar um retorno qualquer
    }
}
