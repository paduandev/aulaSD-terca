package client;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final int PORT = 1234;
        final String IP = "127.0.0.1";
        Socket clientSocket = null;
        Scanner input = null;
        Scanner teclado;
        PrintStream output = null;
        
        // solicitar conexão
        try {
            clientSocket = new Socket(IP, PORT);
        } catch (Exception e) {
            System.out.println("Não foi possível fazer a conexão");
            System.out.println(e.getMessage());
            return;
        }
        
        // comunicação
        try {
            teclado = new Scanner(System.in);
            input = new Scanner(clientSocket.getInputStream());
            output = new PrintStream(clientSocket.getOutputStream());
            String msg;
            do {
                System.out.println("Digite a menssagem:");
                msg = teclado.nextLine();
                output.println(msg);
                //String recebido = input.nextLine();
                //System.out.println("Recebido: " + recebido);
            } while (!msg.equals("exit"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // encerrar conexão
        try {
            clientSocket.close();         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
