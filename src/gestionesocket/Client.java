/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionesocket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utente
 */
public class Client {
    Socket socket;
    BufferedReader tastiera;
    BufferedReader input;
    DataOutputStream output;
    String messaggioRicevuto;
    String messaggioDaInviare;
    //PUNTO 1: ho aperto un socket specificando ip e porta dove risiede il server
    //una volta stabilita la connessione l'ho chiusa
    public static void main(String[] args) {
      
        try {
            Socket socket = new Socket("127.0.0.1",2000);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void comunicazioneClient(){
        try {
            //Inizializzazione degli oggetti di comunicazione lato client
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new DataOutputStream(socket.getOutputStream());
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            //Invio e ricezione di messaggi con il server
            messaggioRicevuto = input.readLine();
            System.out.println("Il server dice: "+messaggioRicevuto);
            System.out.print("La tua risposta al server: ");
            messaggioDaInviare = tastiera.readLine();
            output.writeBytes(messaggioDaInviare);
        } catch (IOException ex) {
            System.err.print(ex);
        }
    }
    
}
