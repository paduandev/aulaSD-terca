package server;

import java.net.Socket;

import util.Comunicacao;
import util.Requisicao;
import util.Resposta;

public class Calcula extends Thread {
    Socket socket;
    Comunicacao comunicacao;

    public Calcula(Socket socket) {
        this.socket = socket;
        comunicacao = new Comunicacao(socket);
    }

    @Override
    public void run() {
        Requisicao requisicao = (Requisicao) comunicacao.receive();

        char operacao = requisicao.getOperador();

        Resposta resposta  = new Resposta();

        switch (operacao) {
            case '+':
                double resultado = requisicao.getOperando1() + 
                                   requisicao.getOperando2();
                resposta.setValor(resultado);
                resposta.setStatus(resposta.OK);
                break;
        
            default:
                resposta.setStatus(resposta.OPERADOR_INVALIDO);
                break;
        }

        comunicacao.send(resposta);
    }
}
