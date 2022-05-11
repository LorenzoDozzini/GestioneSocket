/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package countdownthread;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utente
 */
public class Server {
    ServerSocket ss;
    Socket so;
    BufferedReader br;
    BufferedWriter bw;
    
    public Server(int porta,int t) {
        //creo il server socket, assegno una porta e setto un tempo di timeout dopo il quale il server si chiude
        try {
            ss=new ServerSocket(porta);
            ss.setSoTimeout(t);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inAttesa() {
        try {
            so=ss.accept(); //il server accetta la richiesta di connessione
            br=new BufferedReader(new InputStreamReader(so.getInputStream())); //mi preparo a leggere
            bw=new BufferedWriter(new OutputStreamWriter(so.getOutputStream())); //mi preparo a scrivere
            System.out.println("client connesso: " + so);
            Handler h = new Handler(so);    //creo un oggetto Handler che estendendo l'interfaccia Runnable 
            new Thread(h).start();         //mi permette di istanizare un Thread
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void chiudiServer() {
        try {
            ss.close();    //chiudo il server socket
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
