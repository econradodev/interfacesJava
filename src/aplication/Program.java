package aplication;

import entities.Contrato;
import entities.Prestacao;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        //sistema de pagamentos online

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados dos contratos: ");
        System.out.print("Numero: ");
        int numero = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(sc.next(), fmt);
        System.out.print("Valor do contrato: ");
        double valor = sc.nextDouble();

        Contrato contrato = new Contrato(numero, data, valor);

        System.out.print("Entre com o numero de parcelas: ");
        int parcelas = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        System.out.println("Parcelas: ");

        contractService.processContract(contrato, parcelas);

        for (Prestacao prestacao : contrato.getPrestacoes()) {
            System.out.println(prestacao);
        }


        sc.close();
    }
}