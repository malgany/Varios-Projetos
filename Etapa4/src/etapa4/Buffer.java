package etapa4;

import java.util.ArrayList;

/**
 *
 * @author Christopher
 */
public class Buffer {
    
    private ArrayList lista = new ArrayList();
    private static int quantidade=0;
    private int capacidade;
    
    public Buffer(int capacidade){
        this.capacidade = capacidade;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public int getCapacidade(){
        return capacidade;
    }
    
    public int size(){
        return lista.size();
    }
    
    public synchronized void set(Pedidos p){
            quantidade++;
            p.setNumPedido(quantidade);
            lista.add(p);
            System.out.println(p.getCliente() + "       produziu o pedido " + p.getNumPedido());        
    }
    
    public synchronized Pedidos get(String nome){
        if(lista.size() > 0){
            Pedidos p = (Pedidos) lista.get(0);
            System.out.println(nome + "       consumiu o pedido " + p.getNumPedido());
            return (Pedidos) lista.get(0);
        } else {
            return null;
        }
    }
    
    public synchronized Pedidos consumir(String nome){
        Pedidos ret;
        if(lista.size() > 0){
            ret = get(nome);
            lista.remove(0);
        } else {
            ret = null;
        }
        return ret;
    }
    
}
