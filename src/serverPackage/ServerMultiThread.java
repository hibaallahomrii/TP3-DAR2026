package serverPackage;

import java.net.*;

public class ServerMultiThread {
    public static void main(String[] args) {
        int port = 1234;
        int clientCounter = 0;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Le serveur multi-thread est en attente de clients sur le port " + port + "...");

            while (true) {
                // Attente et acceptation de la connexion d'un client
                Socket socket = serverSocket.accept();
                clientCounter++;

                // Création et lancement d'un thread dédié pour ce client
                ClientHandler clientHandler = new ClientHandler(socket, clientCounter);
                new Thread(clientHandler).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}