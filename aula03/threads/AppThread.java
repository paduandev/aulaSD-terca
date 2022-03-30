package threads;

public class AppThread {
    
    public static void main(String[] args) {
        MyThread t1 = new MyThread("T1");
        MyThread t2 = new MyThread("T2");
        MyThread t3 = new MyThread("T3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Final do main");
    }
}
