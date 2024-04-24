package services;

public class PaypalService implements OnlinePaymentService {
    @Override
    public Double taxaDePagamento(Double valor) {
        return valor + (valor * 0.02);
    }

    @Override
    public Double juros(Double valor, Integer meses) {
        return valor + (valor * 0.01) * meses;
    }
}
