package etapa4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Christopher
 */
public class Etapa4 {

    public static void main(String[] args) throws InterruptedException {
        final int numThreads = 1;
        final int numPedidos = 5000;
        
        Semaphore mutex = new Semaphore(1, true);
        Buffer buffer = new Buffer(numPedidos);
        
        Produtor prod;
        Consumidor cons;
        
        for(int i=0;i<numThreads;i++){
            prod = new Produtor(buffer, mutex, "Produtor     "+(i+1));
            prod.start();
            cons = new Consumidor(buffer, mutex, "Consumidor   "+(i+1));
            cons.start();
        }
    }
}
