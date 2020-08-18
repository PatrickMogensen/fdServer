package com.company;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main  implements Runnable  {

    private BufferedReader bfr;

    public Main(BufferedReader bfr){
        this.bfr = bfr;
    }


    public  void  run(){
        try{

            while (true){
                System.out.println(bfr.readLine());

            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {

        try {
            ServerSocket  serverSocket = new ServerSocket(6780);

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(isr);
            Scanner scanner = new Scanner(System.in);

            Runnable r = new Main(bufferedReader);
            new Thread(r).start();

            while (true){
                pw.println(scanner.nextLine());

            }
        } catch (Exception e){
            System.out.println(e);
        }


    }
}
