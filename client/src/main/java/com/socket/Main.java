package com.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean loopClient = true;
        Socket c = new Socket("Localhost", 2000);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            DataOutputStream out = new DataOutputStream(c.getOutputStream());

            do{

                Scanner parola = new Scanner(System.in);
                Scanner scelta = new Scanner(System.in);
                
                System.out.println("MENU:");
                System.out.println("1. Trasforma un stringa tutta in MAIUSCOLO");
                System.out.println("2. Trasforma un stringa tutta in MINUSCOLO");
                System.out.println("3. RIBALTA i caratteri di una string");
                System.out.println("4. CONTA il numero di caratteri di una stringa");
                System.out.println("Digita la parola 'exit' per USCIRE dal menu");
                
                System.out.println("Inserisci la stringa da modificare");
                String opzione = scelta.nextLine();
                
                if(opzione.equals("exit")){
                    loopClient = false;
                    System.out.println("Il client verrà terminato");
                    out.writeBytes("exit" + "\n");
                }
                else{
                System.out.println("Scegli l'opzione che vuoi fare \n");
                String par = parola.nextLine();

                out.writeBytes(opzione + "\n");
                out.writeBytes(par + "\n");
                }
            }while(loopClient);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Client terminato");
    }
}