package etapa4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Christopher
 */
public class Produtor extends Thread {
    
    private Buffer buffer;
    private Semaphore mutex;
    private String nome;
    private static int i=0;
    
    public Produtor(Buffer buffer, Semaphore mutex, String nome){
        this.buffer = buffer;
        this.mutex = mutex;
        this.nome = nome;
    }
    
    
    private synchronized void produzir(){
        Pedidos p = new Pedidos();
        i++;
        p.setCliente(nome);
        p.setPedido("Pedido " + (i));
        buffer.set(p);
        
    }
    
    @Override
    public void run(){
        try {
            
            while(buffer.getQuantidade() < buffer.getCapacidade()){
                mutex.acquire();
                Thread.currentThread().sleep(10000);
                if(buffer.getQuantidade() < buffer.getCapacidade())
                    produzir();
                mutex.release();
            }
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
