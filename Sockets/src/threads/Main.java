package threads;

public class Main {

    public static void main(String[] args) {
        Thread t1 = new Tarefa1();
        Thread t2 = new Thread(new Tarefa2());
        
        t1.start();
        t2.start();
    }
    
}
