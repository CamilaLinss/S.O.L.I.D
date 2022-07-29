package com.example.InjectDependency;

import com.example.InjectDependency.pagamento.*;
import com.example.InjectDependency.pagamento.interfaces.IGatewayPagamentos;
import com.example.InjectDependency.venda.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;


//COM A AJUDA DE UM FRAMEWORK, CONSEGUIMOS DE FORMA AUTOMATICA E MAIS FACIL GERAR ESSAS INJEÇÕES DE DEPENDENCIAS
//MELHORANDO AINDA MAIS A ESCRITA E MANUTENÇÃO DO CODIGO

//Obs: Cada framework de cada tecnologia tem sua forma de configurar as injeções

@SpringBootApplication
public class InjectDependencyApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(InjectDependencyApplication.class, args);

		// O spring levanta um container focado em gerar o IOC do projeto, onde ele vai gerar os beans configurados
		// podemos ter acesso a esse container quando capturamos em uma var do tipo ApplicationContext, o que o
		// SpringApplication.run nos retorna, com isso podemos ter acesso aos beans gerenciados pelo spring

		System.out.println("Efetuando compra");

									// Peço o bean do tipo VendaService que ele gerou
		VendaService vendaService = appContext.getBean(VendaService.class);


		// Aqui fica mais claro o porque esse tipo de classe eu posso intanciar com 'new', pois não faz sentido
		// o spring gerenciar pra mim uma instancia de entidade, que é maleavel conforme os dados são inputados
		// e sua relação com a classe que a instanciou é bem mais simples do que as outras

		// Podemos ter centenas de Mercadorias de diferentes valores e não é o spring que vai gerenciar isso
		Mercadoria mercadoria = new Mercadoria();
		mercadoria.valor = new BigDecimal(200);
		mercadoria.Nome = "Controle PS4";

		vendaService.registrar(mercadoria);

	}

}
