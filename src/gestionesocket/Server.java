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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utente
 */
public class Server {
    ServerSocket serverSocket;
    Socket socket;
    BufferedReader input;
    DataOutputStream output;
    String messaggioRicevuto;
    String messaggioDaInviare;
    //PUNTO 1: ho stabilito la porta dove il server resta in ascolto tramite un istanza della classe ServerSocket
    // con il metodo accept() accetto le richieste di connessione al server e una volta fatto chiudo la connessione con il client
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket serverSocket=new ServerSocket(2000);
             System.out.println("Server avviato correttamente");
            Socket socket=serverSocket.accept();
             System.out.println("Connessione stabilita");
            System.out.println("Socket: "+ socket);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void comunicazioneServer(){
        try {
            //Inizializzazione degli oggetti di comunicazione lato server
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new DataOutputStream(socket.getOutputStream());
            //Invio e ricezione di messaggi con il server
            messaggioDaInviare = "Benvenuto!";
            output.writeBytes(messaggioDaInviare);
            messaggioRicevuto = input.readLine();
            System.out.println("Il client risponde: "+messaggioRicevuto);
        } catch (IOException ex) {
            System.err.print(ex);
        }
    }
    
}
