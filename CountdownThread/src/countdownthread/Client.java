/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package countdownthread;

import java.net.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utente
 */
public class Client {
    Socket cl;
    BufferedReader br;
    BufferedWriter bw;
    
    public Client(InetAddress ip, int porta) {
        try {
            //Socket
            cl=new Socket(ip, porta);
            //inizializzo bufferedReader e bufferedWriter
            //bufferedReader, leggo il messaggio dal server (dataSocket)
            br=new BufferedReader(new InputStreamReader(cl.getInputStream()));
            //bufferedWriter, mando il messaggio al server (dataSocket)
            bw=new BufferedWriter(new OutputStreamWriter(cl.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String lettura() {
        String msg = null; //variabile null per poter ""returnare"" la variabile fuori dal try catch
        try {
            msg = br.readLine(); //leggo
        } catch (IOException ex) { 
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
    public void scrittura(String testo) {
        try {
            //scrivo al server un testo dato come parametro alla funzione
            bw.write(testo+"\n");
            bw.flush(); //manda il messaggio, libera ram
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void chiusura() {
        try {
            cl.close();
        } catch (IOException ex) {
            //System.out.println("c'è un errore nella chiusura del socket");
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
