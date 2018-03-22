package tcpthreads;

import java.util.*;

public class ServerStatus {

    String arquiteturaSO;
    String dataSO;
    String nomeThread;
    String nomeSO;
    String versaoSO;

    public ServerStatus(String nameThread) {
        Date data = new Date();
        nomeSO = System.getProperty("os.name");
        versaoSO = System.getProperty("os.version");
        arquiteturaSO = System.getProperty("os.arch");
        dataSO = data.toString();
        nomeThread = nameThread;
    }

    @Override
    public String toString() {

        String estado;
        estado = nomeSO + " Version " + versaoSO
                + "\nArquitetura: " + arquiteturaSO + "\n"
                + dataSO + " \n" + nomeThread;
        return estado;

    }
}
