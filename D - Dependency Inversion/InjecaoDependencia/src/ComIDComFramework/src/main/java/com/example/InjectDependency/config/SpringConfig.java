package com.example.InjectDependency.config;

import com.example.InjectDependency.pagamento.PagSeguro;
import com.example.InjectDependency.pagamento.PayPal;
import com.example.InjectDependency.pagamento.interfaces.IGatewayPagamentos;
import com.example.InjectDependency.venda.VendaService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Com essa anotação indicamos a classe de configuração do projeto, que vai ser executada antes do codigo principal
// Aqui vamos lidar com os beans, que nada mais são do que os objetos que vamos entregar para o spring gerenciar

@Configuration
public class SpringConfig {

    @Bean     // Com esse bean gerado, em qualquer momento da aplicação onde for requisitado o uso do PagSeguro, o spring
             // vai identificar essa instancia gerada
            // para usar o paypal, basta apagar este bean e criar um bean do PayPal
    public PagSeguro pagSeguro(){
        return new PagSeguro("2142");
    }


    @Primary
    @Bean   // Aqui deixamos os dois, ou seja duas classes que implementam o IGatewayPagamentos, nisso o spring
            // vai lançar uma excessão, pois vai ficar confuso em qual dos dois utilizar, por isso utilizamos
            // @Primary para caso tenhamos esses conflitos de preferencia, o spring boot saiba qual dos dois dar prioridade
    public PayPal payPal(){
        return new PayPal("2142", "camz");
    }


    @Bean    // Aqui o spring entende que ele vai ter que passar como parametro um IGatewayPagamentos e nisso vai
            // entender que entre os beans gerados, ele tem um bean PagSeguro (ou poderia ser um bean de paypal)
           // que implementa essa interface, com isso passando o objeto pagseguro (ou paypal) nesse parametro
    public VendaService vendaService(IGatewayPagamentos iGatewayPagamentos){
        return new VendaService(iGatewayPagamentos);
    }

    // !! Veja no projeto de DICAS uma alternativa para não ter que declarar este bean, utilizando os Annotations !!
}
