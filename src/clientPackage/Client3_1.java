package clientPackage;

import java.io.*;
import java.net.*;

public class Client3_1 {
    public static void main(String[] args) {
        try {
            String serverHost = "localhost";
            int port = 1234;

            System.out.println("Connexion au serveur...");
            Socket socket = new Socket(serverHost, port);
            System.out.println("Connecté au serveur !");

            // Lecture du message d'accueil et du numéro d'ordre envoyé par le serveur
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String reponseServeur = br.readLine();
            System.out.println(reponseServeur);

            // Envoi d'un message au serveur
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("Bonjour, je suis un client connecte.");

            // Lecture de l'écho du serveur
            String echo = br.readLine();
            System.out.println(echo);

            // Fermeture de la socket
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}