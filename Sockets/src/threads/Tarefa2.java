package threads;

public class Tarefa2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " - usando interface");
            /*try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Erro.");
            }*/
        }

    }

}
