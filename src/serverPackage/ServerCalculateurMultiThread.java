package serverPackage;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerCalculateurMultiThread {
    // Compteur global partagé par tous les threads (ressource critique)
    private static int nombreOperations = 0;

    // Méthode synchronisée pour incrémenter et afficher le compteur en toute sécurité
    public static synchronized void incrementerCompteur() {
        nombreOperations++;
        System.out.println(">>> Compteur global des opérations traitées : " + nombreOperations);
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Le serveur de calcul multi-thread est en écoute sur le port 1234...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nouveau client connecté : " + socket.getRemoteSocketAddress());

                // Lancer un thread dédié pour ce client
                new Thread(new ClientCalculProcess(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}