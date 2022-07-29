package ComIDSemInterface.src;

import ComIDSemInterface.src.pagamento.PagSeguro;
import ComIDSemInterface.src.venda.Mercadoria;
import ComIDSemInterface.src.venda.VendaService;

import java.math.BigDecimal;


//AQUI VAMOS INICIAR O ENTENDIMENTO DO ID - COM INJEÇÃO VIA CONSTRUTOR

public class main {

    public static void main(String[] args) {
        System.out.println("Efetuando compra");

        //Classes que são entidades, tem a necessidade de aplicar ID ? Geralmente não, pois ela é usada apenas como um
        //modelo com atributos de entidades do negocio, onde sua relação com a classe que a instancia é simples
        //Devemos lembrar que design patterns devem ser usados quando realmente um valor é agreado ou problema é resolvido
        Mercadoria mercadoria = new Mercadoria();
        mercadoria.valor = new BigDecimal(200);
        mercadoria.Nome = "Controle PS4";

        //Observe que agora passamos a instancia da pagseguro ja no construtor, com o parametro solicitado
        //Apesar de conseguir melhorar bastante o codigo, ainda temos alguns conceitos a aplicar
        VendaService vendaService = new VendaService(new PagSeguro("21123324"));

        vendaService.registrar(mercadoria);

    }

}

