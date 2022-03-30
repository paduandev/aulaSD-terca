package threads;

public class MyThread extends Thread {

    public MyThread(String nome) {
        super(nome);
    }

    @Override
    public void run() {
        System.out.println("Thread " + getName() + " iniciou.");
        
        try {
            sleep(2000); // dorme por 2 segundos
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Thread " + getName() + " finalizou.");
    }
}