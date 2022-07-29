package ComIDComInterface.src.venda;

import ComIDComInterface.src.pagamento.interfaces.IGatewayPagamentos;

// Agora sim temos um ID, onde se trata exatamente de injetar as dependencias inves da propria classe ter que instanciar
// cada uma

public class VendaService {

    // Agora não temos mais um tipo especifico e sim a interface, a classe Venda Service agora não tem contato nenhum com
    // o que esta atras dessa interface, por tanto são desacopladas, ja que se algo mudar, nada vai afetar a VendaService e
    // a mesma não precisa saber como foi implementado por tras

    // Permitindo que caso queira mudar da PagSeguro para Paypal, não teremos graneds impactos e mudanças
    // A unica dependencia que VendaService tem é com a propria interface
    private IGatewayPagamentos pagamento;

    public VendaService(IGatewayPagamentos pagamento){
        this.pagamento = pagamento;
    }


    public void registrar(Mercadoria mercadoria){

        System.out.println("Registrando venda do produto " + mercadoria.Nome + " no valor de " + mercadoria.valor + " reais");

        pagamento.pagar(mercadoria.valor);
    }
}
