package client;

import java.net.Socket;

import util.Comunicacao;
import util.Requisicao;
import util.Resposta;

public class Client {
    public static void main(String[] args) {
        final int PORT = 9876;
        final String IP = "127.0.0.1";
        Socket socket;

        try {
            socket = new Socket(IP, PORT);

            Requisicao requisicao = new Requisicao(2, 5, '+');

            Comunicacao comunicacao = new Comunicacao(socket);

            comunicacao.send(requisicao);

            Resposta resposta = (Resposta) comunicacao.receive();

            if(resposta.getStatus() == resposta.OK) {
                System.out.println("Resutado: " + resposta.getValor());
            } else {
                System.out.println("Erro no calculo.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
