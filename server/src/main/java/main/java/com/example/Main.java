package main.java.com.example;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {

        try (ServerSocket ss = new ServerSocket(2000)) {
            System.out.println("Il server e' partito");

            while (true) {
                ServerThread ts = new ServerThread(ss.accept());
                ts.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}