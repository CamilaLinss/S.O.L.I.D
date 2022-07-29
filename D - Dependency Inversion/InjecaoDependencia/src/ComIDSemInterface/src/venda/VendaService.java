package ComIDSemInterface.src.venda;

import ComIDSemInterface.src.pagamento.PagSeguro;


public class VendaService {

    // Uma forma de fazer ID é injeção atraves do construtor da classe, aqui apenas criamos um atributo, que recebe a
    // instancia do PagSeguro, assim fazemos com que a instancia ocorra apenas de forma externa, apenas quem chamar
    // Venda service vai ter que passar a instancia da PagSeguro. Portanto removemos o 'new' e os parametros que tinham aqui

    // Dessa forma fica indiferente para o Venda Service saber da onde esta vindo essa instancia

    private PagSeguro pagamento;

    // Agora se quisermos usar o paypal inves do pagseguro, teremos que trazer sua dependencia também, porem ainda
    // teremos que alterar essa classe VendaService , toda vez que queremos um meio de pagamento novo

    //private Paypal pagamento;


    public VendaService(PagSeguro pagamento){
        this.pagamento = pagamento;
    }


    public void registrar(Mercadoria mercadoria){

        System.out.println("Registrando venda do produto " + mercadoria.Nome + " no valor de " + mercadoria.valor + " reais");

        //PagSeguro pagamento = new PagSeguro("324234");

        pagamento.pagar(mercadoria.valor);
    }
}
