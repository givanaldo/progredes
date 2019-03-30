package threads;

public class Tarefa implements Runnable {
    String nome;

    public Tarefa(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        for (int i=1; i<=100; i++)
            System.out.println(i + " - processo de " + this.nome);
    }
}
