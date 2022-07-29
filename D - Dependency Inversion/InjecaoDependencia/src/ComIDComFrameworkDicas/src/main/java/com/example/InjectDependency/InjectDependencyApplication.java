package com.example.InjectDependency;

import com.example.InjectDependency.pagamento.*;
import com.example.InjectDependency.pagamento.interfaces.IGatewayPagamentos;
import com.example.InjectDependency.venda.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;


// DICAS PARA ECONOMIZAR LINHAS DE CODIGO, FAZENDO UM GERENCIAMENTO DE BEANS DE FORMA RAPIDA E EFICIENTE

//Obs: Cada framework de cada tecnologia tem sua forma de configurar as injeções

@SpringBootApplication
public class InjectDependencyApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(InjectDependencyApplication.class, args);

		System.out.println("Efetuando compra");

		VendaService vendaService = appContext.getBean(VendaService.class);


		// Aqui fica mais claro o porque esse tipo de classe eu posso intanciar com 'new', pois não faz sentido
		// o spring gerenciar pra mim uma instancia de entidade, que é maleavel conforme os dados são inputados
		// e sua relação com a classe que a instanciou é bem mais simples do que as outras

		// Podemos ter centenas de Mercadorias de diferentes valores e não é o spring que vai gerenciar isso
		// Para testes, não tenho problema em usar essa classe em seu contexto real, na verdade é ate bom utilizar
		Mercadoria mercadoria = new Mercadoria();
		mercadoria.valor = new BigDecimal(200);
		mercadoria.Nome = "Controle PS4";

		vendaService.registrar(mercadoria);

	}

}
