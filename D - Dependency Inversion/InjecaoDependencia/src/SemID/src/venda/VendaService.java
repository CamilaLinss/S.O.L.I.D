package SemID.src.venda;

import SemID.src.pagamento.PagSeguro;

//Classe de ALTO nivel
public class VendaService {

    // Classe de alto nivel dependendo de uma classe de baixo nivel
    public void registrar(Mercadoria mercadoria){

        System.out.println("Registrando venda do produto " + mercadoria.Nome + " no valor de " + mercadoria.valor + " reais");

        PagSeguro pagamento = new PagSeguro("324234");                // Em um projeto maior todas as classes que precisar do PagSeguro vai ter
                                                                            // que instanciar com 'new' novamente e caso a forma de instanciar mude (adicionar mais
                                                                            // um parametro por ex) teremos que mudar em todas as classes que estão instanciando a
                                                                            // PagSeguro
        pagamento.pagar(mercadoria.valor);
        // Agora imagine se eu quiser usar outro gateway de pagamento, como o paypal, terei que criar mais instancias e mais acoplamento

    }
}
