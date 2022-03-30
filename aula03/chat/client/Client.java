package chat.client;

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

            Escuta e = new Escuta(input);
            e.start();

            String msg;
            do {
                System.out.println("Digite a menssagem:");
                msg = teclado.nextLine();
                output.println(msg);
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
