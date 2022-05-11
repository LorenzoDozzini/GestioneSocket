/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package countdownthread;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utente
 */
public class MainClient {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
    //    int tempo = 0;
        int porta = 2000;
        try {
            InetAddress IP = InetAddress.getLocalHost();
            //creo un oggetto dell'istanza client
            Client c = new Client(IP, porta);
            //leggo il messaggio del server
            System.out.println(c.lettura());
            
            //istanzio il timer e lo faccio partire una volta arrivato il messaggio del server
            //tempo = Integer.parseInt(c.lettura());
            //CountDown timer = new CountDown(tempo);
            //timer.start();
            c.chiusura();
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
