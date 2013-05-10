package etapa4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Christopher
 */
public class Consumidor extends Thread {
    
    private Buffer buffer;
    private Semaphore mutex;
    private String nome;
    private static int i=0;
    
    //Construtor para Exclusão Mútua apenas
    public Consumidor(Buffer buffer, Semaphore mutex, String nome){
        this.buffer = buffer;
        this.mutex = mutex;
        this.nome = nome;
    }
    
    
    private synchronized Pedidos consumir(){
        Pedidos p = new Pedidos();
        p = buffer.consumir(nome);
        return p;
    }
    
    @Override
    public void run(){
        try {
            
            while(buffer.size() > 0 || buffer.getQuantidade() < buffer.getCapacidade()){
                mutex.acquire();
                Thread.currentThread().sleep(10000);
                if(buffer.size() > 0){
                    consumir();
                } else if(buffer.getQuantidade() < buffer.getCapacidade()){
                    System.out.println(nome + " tentou consumir, lista vazia.");
                }
                mutex.release();
            }
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
