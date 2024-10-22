package main.java.com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread {

    Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    public void run() {

        try {

            System.out.println("Un client si e' connesso");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            do {

                String stringaRicevuta = in.readLine();

                if(stringaRicevuta.equals("exit")){
                    System.out.println("Il client vuole chiudere la connessione");
                    s.close();
                    System.out.println("Il client ha chiuso la connessione");
                    break;
                }else{

                String scelta = in.readLine();

                switch (scelta) {

                    case "1":
                        String stringaMandata = stringaRicevuta.toUpperCase();
                        System.out.println("La stringa e' stata transformata in MAIUSCOLO: " + stringaMandata);                     
                        break;
                    case "2":
                        String stringaMandata2 = stringaRicevuta.toLowerCase();
                        System.out.println("La stringa e' stata transformata in MINUSCOLO: " + stringaMandata2); 
                        break;
                    case "3":
                        StringBuilder reversStringa = new StringBuilder();
                        reversStringa.append(stringaRicevuta);
                        reversStringa.reverse();
                        System.out.println("La tua stringa RIBALTATA e': " + reversStringa);
                        break;
                    case "4":
                        out.writeBytes(stringaRicevuta.length() + "\n");
                        break;
                }
            }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
