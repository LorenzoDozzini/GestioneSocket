/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package countdownthread;

/**
 *
 * @author Utente
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int PORT = 2000;
        int TIME = 20000;
        
        Server s=new Server(PORT,TIME);
        while(true){
            //creo oggetto timer e gli assegno la variabile del tempo
 //           CountDown timerAttesa = new CountDown(TIME);
            //il server accetta la comunicazione
            s.inAttesa();
            //manda il tempo per poi far partire il timer
   //         s.scrivi("il server sarà in ascolto per: "+(TIME/1000)+" secondi");
    //        s.scrivi(String.valueOf(TIME));
            //parte il timer
    //        timerAttesa.start();
        }
    }
}

