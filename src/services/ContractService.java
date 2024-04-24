package services;

import entities.Contrato;
import entities.Prestacao;

import java.time.format.DateTimeFormatter;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract (Contrato contrato, Integer meses){
        double valorTaxado;

        for (int i = 1; i <= meses; i++){
            valorTaxado = onlinePaymentService.juros(contrato.getValorTotal()/meses, i);
            contrato.getPrestacoes().add(new Prestacao(contrato.getData().plusMonths(i), onlinePaymentService.taxaDePagamento(valorTaxado)));
        }
    }
}
