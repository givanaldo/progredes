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
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss");
        while (true) {
            try {
            	labelHora.setText(hora.format(new Date()));
            	//Date hora = new Date();
            	//labelHora.setText(hora.toString());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }   
}