package threads;

public class Tarefa1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " - usando herança");
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Erro.");
            }*/
        }
    }

}
