package util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Comunicacao {
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    public Comunicacao(Socket socket) {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void send(Object object) {
        try {
            out.writeObject(object);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Object receive()  {
        try {
            return in.readObject();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }
    
}
