package SemID.src;

import SemID.src.venda.Mercadoria;
import SemID.src.venda.VendaService;

import java.math.BigDecimal;


//AQUI VAMOS FAZER UM EXEMPLO SEM ID E QUAIS PROBLEMAS ENCONTRAMOS

public class main {

    public static void main(String[] args) {
        System.out.println("Efetuando compra");

        // Classes que são entidades, tem a necessidade de aplicar ID ? Geralmente não, pois ela é usada apenas como um
        // modelo com atributos de entidades do negocio, onde sua relação com a classe que a instancia é simples
        // Devemos lembrar que design patterns devem ser usados quando realmente um valor é agreado ou problema é resolvido

        // Podemos ter centenas de Mercadorias de diferentes valores e não é o spring que vai gerenciar isso
        // Para testes, não tenho problema em usar essa classe em seu contexto real, na verdade é ate bom utilizar
        Mercadoria mercadoria = new Mercadoria();
        mercadoria.valor = new BigDecimal(200);
        mercadoria.Nome = "Controle PS4";

        VendaService vendaService = new VendaService();
        vendaService.registrar(mercadoria);

    }

}

