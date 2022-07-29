package ComIDComInterface.src;

import ComIDComInterface.src.pagamento.PagSeguro;
import ComIDComInterface.src.pagamento.PayPal;
import ComIDComInterface.src.pagamento.interfaces.IGatewayPagamentos;
import ComIDComInterface.src.venda.Mercadoria;
import ComIDComInterface.src.venda.VendaService;

import java.math.BigDecimal;


//AQUI VAMOS APRIMORAR O DESACOPLAMENTO COM ABSTRAÇÕES (INTERFACES)

public class main {

    public static void main(String[] args) {
        System.out.println("Efetuando compra");

        //Classes que são entidades, tem a necessidade de aplicar ID ? Geralmente não, pois ela é usada apenas como um
        //modelo com atributos de entidades do negocio, onde sua relação com a classe que a instancia é simples
        //Devemos lembrar que design patterns devem ser usados quando realmente um valor é agreado ou problema é resolvido
        Mercadoria mercadoria = new Mercadoria();
        mercadoria.valor = new BigDecimal(200);
        mercadoria.Nome = "Controle PS4";

        IGatewayPagamentos Ps = new PagSeguro("34242");
        IGatewayPagamentos Pp = new PayPal("34242", "camz");

        //Consigo trocar de forma facil, qual gateway de pagamento vou utilizar, sem precisar mexer nas outras classes
        //Porem ainda temos como melhorar mais ainda essa interação, com ajuda de frameworks
        VendaService vendaService = new VendaService(Ps);

        vendaService.registrar(mercadoria);

    }

}

