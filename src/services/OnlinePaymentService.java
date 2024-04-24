package services;

public interface OnlinePaymentService {
    Double taxaDePagamento (Double valor);
    Double juros (Double valor, Integer meses);
}
