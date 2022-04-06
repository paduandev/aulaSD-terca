package client;

import java.net.Socket;
import java.util.Scanner;

import util.Comunicacao;
import util.Requisicao;
import util.Resposta;

public class Client {
    public static void main(String[] args) {
        final int PORT = 9876;
        final String IP = "127.0.0.1";
        Socket socket;
        double operando1, operando2;
        char operador;
        Scanner scanner = new Scanner(System.in);;

        try {
            socket = new Socket(IP, PORT);

            System.out.println("*********************************");
            System.out.println("***  CALCULADORA DISTRIBUIDA  ***");
            System.out.println("*********************************");
            System.out.println("Digite o primeiro numero");
            operando1 = Double.parseDouble(scanner.nextLine());
            System.out.println("Digite o segundo numero");
            operando2 = Double.parseDouble(scanner.nextLine());
            System.out.println("Escolha uma operação");
            System.out.println("(+)SOMA (-)SUBTRACAO (x)MULTIPLICACAO (/)DIVISAO");
            operador = scanner.nextLine().charAt(0);
    
            Requisicao requisicao = new Requisicao(operando1, operando2, operador);
            
            Comunicacao comunicacao = new Comunicacao(socket);
            
            comunicacao.send(requisicao);
            
            Resposta resposta = (Resposta) comunicacao.receive();

            if(resposta.getStatus() == resposta.OK) {
                System.out.println("Resutado: " + resposta.getValor());
            } else {
                if (resposta.getStatus() == resposta.OPERADOR_INVALIDO) {
                    System.out.println("Operacao nao Implementada");
                } else {
                    System.out.println("Divisao por Zero");
                }
                System.out.println("Erro no calculo.");
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
