
import java.awt.Container;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge
 */
public class Servidor extends UnicastRemoteObject implements ServidorRemoto {

    public static JFrame frame = new JFrame("CHAT - Servidor");
    public static JButton bEnviar;
    public static JTextArea tMensagemRecebe;
    public static JTextArea tMensagemEnvia;
    public ClienteRemoto cliente;

    public Servidor() throws RemoteException
    {
        super();
    }

    public void registrarCliente(ClienteRemoto cliente) throws RemoteException {
        this.cliente = cliente;
    }

    public void receberMensagem(String msg) throws RemoteException {
        tMensagemRecebe.setText(tMensagemRecebe.getText() + "\n" + msg);
    }

    public void enviarMensagem() throws RemoteException
    {
        this.cliente.receberMensagem(tMensagemEnvia.getText());
    }

    public static void main (String args[]) throws RemoteException, MalformedURLException
    {
        final Servidor servidor = new Servidor();
        Registry registry = LocateRegistry.createRegistry(1099);
        Naming.rebind("ChatServidor", servidor);

        Container c= frame.getContentPane();
        c.setLayout(null);

        bEnviar=new JButton("Enviar");
        bEnviar.setBounds(300,80,100,25);
        c.add(bEnviar);

        bEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    servidor.enviarMensagem();
                } catch (RemoteException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        tMensagemRecebe = new JTextArea();
        tMensagemRecebe.setBounds(20,130,380,150);
        c.add(tMensagemRecebe);

        tMensagemEnvia = new JTextArea();
        tMensagemEnvia.setBounds(20,300,380,150);
        c.add(tMensagemEnvia);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
