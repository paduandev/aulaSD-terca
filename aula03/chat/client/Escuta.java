package chat.client;

import java.util.Scanner;

public class Escuta extends Thread {
    private Scanner input;
    
    public Escuta(Scanner input) {
        this.input = input;
    }

    @Override
    public void run() {
        String msg ;
        do {
            msg = input.nextLine();
            System.out.println("Recebido: " + msg);
        } while (!msg.equals("exit"));
    }

}
