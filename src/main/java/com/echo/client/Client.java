package com.echo.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  {
        try {
            // Creating the client socket
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Initialized client...");

            // Data flow for submission
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("Hello server");
            printWriter.flush();

            // Closing connections
            printWriter.close();
            socket.close();
            System.out.println("Finished client...");
        } catch (Exception e){
            System.out.println("Error on the part of the client");
        }
    }
}
