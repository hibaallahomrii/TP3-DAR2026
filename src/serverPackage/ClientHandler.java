package serverPackage;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private int clientId;

    public ClientHandler(Socket socket, int clientId) {
        this.socket = socket;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        try {
            // Affichage des informations du client connecté côté serveur
            InetSocketAddress remoteAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            System.out.println("Client n°" + clientId + " connecté - Adresse IP : " + remoteAddress.getAddress().getHostAddress());

            // Flux pour envoyer des données au client
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            // Envoyer à chaque client son numéro d'ordre de communication
            pw.println("Bienvenue ! Vous êtes le client n°" + clientId);

            // Flux pour lire les messages envoyés par le client
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;

            while ((message = br.readLine()) != null) {
                System.out.println("Message reçu du client n°" + clientId + " : " + message);
                pw.println("Écho du serveur : " + message);
            }

        } catch (IOException e) {
            System.out.println("Connexion fermée pour le client n°" + clientId);
        }
    }
}