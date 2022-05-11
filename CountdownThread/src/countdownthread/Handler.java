/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdownthread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utente
 */
//La classe gestisce le comunicazioni tra client e server e rende multi-threaded la comunicazione
public class Handler implements Runnable{ //interfaccia che utilizza la classe Thread
    ServerSocket ss;
    Socket so;
    BufferedReader br;
    BufferedWriter bw; 
    
    public Handler(Socket socket){ //costruttore
            this.so = socket;
        }
    @Override
    public void run() {
        br = null;
        bw = null;
        try {
            br=new BufferedReader(new InputStreamReader(so.getInputStream())); //mi preparo a leggere
            bw=new BufferedWriter(new OutputStreamWriter(so.getOutputStream())); //mi preparo a scrivere
            String msg;
            while ((msg = br.readLine()) != null) {
                    // writing the received message from client
                    System.out.printf(" Sent from the client: %s\n", msg);
                    bw.write(msg);
                }
        } catch (IOException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        //controlli aggiuntivi
        finally{
            try{
             if (bw != null) { 
                        bw.close();
                    }
             if (br != null) {
                        br.close();
                        so.close();
                    }
            } catch (IOException ex){
                 Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //chiudiConnessione();
    }
    
     public void scrivi(String s) {
        try {
            bw.write(s+"\n");
            bw.flush(); 
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void chiudiConnessione() {
        try {
            so.close();  //chiudo il socket, quindi la connessione
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public void leggi() {
        try {
            System.out.println(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
