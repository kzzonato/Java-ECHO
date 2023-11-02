package com.echo.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // Responsible for listening to incoming connections.
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Initialized server...");

            // This loop will continue to run until the server is closed.
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: "+socket.getInetAddress());

                // Reads the client's messages.
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = bufferedReader.readLine();
                System.out.println("Client: " + message);

                // Closing connections
                bufferedReader.close();
                socket.close();
                serverSocket.close();
                System.out.println("Finished server...");
            }
        } catch (Exception e) {
            System.out.println("Error on the part of the server");
        }
    }
}
