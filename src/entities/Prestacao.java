package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestacao {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate dataDeVencimento;
    private Double valor;

    public Prestacao(LocalDate dataDeVencimento, Double valor) {
        this.dataDeVencimento = dataDeVencimento;
        this.valor = valor;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return dataDeVencimento.format(fmt) + " - " + String.format("%.2f", valor);
    }
}
