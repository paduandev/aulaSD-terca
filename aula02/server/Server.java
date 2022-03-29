package server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        final int PORT = 1234;
        ServerSocket serverSocket;
        Socket clientSocket = null;
        Scanner input = null;
        PrintStream output = null;

        // criar o socket
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (Exception e) {
            System.out.println("Porta em uso...");
            System.out.println(e.getMessage());
            return;
        }

        // esperar a conexão
        try {
            System.out.println("Aguardando conexão...");
            clientSocket = serverSocket.accept();
            // System.out.println("conectado com " + clientSocket.get);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // comunicação
        try {
            input = new Scanner(clientSocket.getInputStream());
            output = new PrintStream(clientSocket.getOutputStream());
            String recebido;
            do {
                recebido = input.nextLine();
                System.out.println("Recebido: " + recebido);
                // output.println("Boa noite cliente!");
            } while (!recebido.equals("exit"));
        } catch (Exception e) {
            System.out.println("Erro na comunicação");
            System.out.println(e.getMessage());
        }

        // encerrar conexão
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}