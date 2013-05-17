
import java.awt.Container;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
public class Cliente extends UnicastRemoteObject implements ClienteRemoto{

    public static JFrame frame = new JFrame("CHAT - Cliente");
    public static JButton bEnviar;
    public static JTextArea tMensagemRecebe;
    public static JTextArea tMensagemEnvia;

    public Cliente() throws RemoteException{
        super();
    }

    public void receberMensagem(String msg) throws RemoteException {
        tMensagemRecebe.setText(tMensagemRecebe.getText() + "\n" + msg);
    }

    public void enviarMensagem(ServidorRemoto servidor) throws RemoteException
    {
        servidor.receberMensagem(tMensagemEnvia.getText());
    }

    public void registrarCliente(ServidorRemoto servidor) throws RemoteException
    {
        servidor.registrarCliente(this);
    }

    public static void main (String args[]) throws RemoteException, NotBoundException, MalformedURLException
    {
        final Cliente cliente = new Cliente();
        final ServidorRemoto servidorRemoto = (ServidorRemoto)Naming.lookup("rmi://localhost/ChatServidor");
        cliente.registrarCliente(servidorRemoto);

        Container c= frame.getContentPane();
        c.setLayout(null);

        bEnviar=new JButton("Enviar");
        bEnviar.setBounds(300,80,100,25);
        c.add(bEnviar);

        bEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cliente.enviarMensagem(servidorRemoto);
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
