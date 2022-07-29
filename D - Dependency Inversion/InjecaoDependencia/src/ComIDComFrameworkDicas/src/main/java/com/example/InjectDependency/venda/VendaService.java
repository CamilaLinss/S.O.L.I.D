package com.example.InjectDependency.venda;

import com.example.InjectDependency.pagamento.interfaces.IGatewayPagamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


// Com essas anotações dizemos que essa classe é um componente spring e que provavelmente vai precisar ser injetado como dependencia
// de outras classes, portanto ele ja vai gerar um bean, sem precisarmos declarar explicitamente no SpringConfig

//@Component
//@Repository
@Service
public class VendaService {

    //private IGatewayPagamentos pagamento;

    // Uma das vantagens da injeção via construtor é que obrigamos que seja passado um IGatewayPagamentos no momento de
    // instanciar o VendaService, ou seja não tem como criar um VendaService que tenha um IGatewayPagamentos nulo
    // Porem se voce tem muitas dependencias em uma classe, pode começar a ficar muitas linhas no codigo

    //public VendaService(IGatewayPagamentos pagamento){
        //this.pagamento = pagamento;
    //}


    // Utilizando Essa anotação, não precisamos injetar via construtor, pois o spring ja vai entender o bean que ele
    // precisa atribuir
    // OBS: Um ponto de atenção é que este meio pode causar uma dificuldade na hora do teste, por conta de
    // atributos e metodos privados (existem bibliotecas que podem ajudar)
    @Autowired
    private IGatewayPagamentos pagamento;


    public void registrar(Mercadoria mercadoria){

        System.out.println("Registrando venda do produto " + mercadoria.Nome + " no valor de " + mercadoria.valor + " reais");

        pagamento.pagar(mercadoria.valor);
    }
}
