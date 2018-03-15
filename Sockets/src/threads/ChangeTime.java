package threads;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class ChangeTime implements Runnable {

    private final JLabel labelHora;
    
    public ChangeTime(JLabel labelHora) {
        this.labelHora = labelHora;
    }
    
    @Override
    public void run() {
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
        while (true) {
            labelHora.setText(hora.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }   
}