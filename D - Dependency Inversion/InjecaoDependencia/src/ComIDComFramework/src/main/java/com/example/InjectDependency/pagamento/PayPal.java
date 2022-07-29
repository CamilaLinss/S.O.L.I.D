package com.example.InjectDependency.pagamento;


import com.example.InjectDependency.pagamento.interfaces.IGatewayPagamentos;

import java.math.BigDecimal;

public class PayPal implements IGatewayPagamentos {

    String cartao;
    String usuario;

    //Solicita credenciais e dados diferentes
    public PayPal(String cartao, String usuario){
        this.cartao = cartao;
        this.usuario = usuario;
    }

    @Override
    public void pagar(BigDecimal valor){

        System.out.println("[PayPal] Pagamento no valor de " + valor +" reais no cartao " + this.cartao + " efetuado com sucesso");

    }
}
