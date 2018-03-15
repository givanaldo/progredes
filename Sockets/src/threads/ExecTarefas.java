package threads;

public class ExecTarefas {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Tarefa("João"));
        Thread t2 = new Thread(new Tarefa("Maria"));
        Thread t3 = new Thread(new Tarefa("José"));

        try {
            t1.setName("Proc 1");
            t1.start();
            t2.setName("Proc 2");
            t2.start();
            t3.setName("Proc 2");
            t3.start();

            /*
            t1.join();
            t2.join();
            t3.join();
            */
            
            System.out.println("Terminaram todas as Threads");
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
        System.out.println("Terminou");
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        System.out.println(t3.getName());
    }

}
