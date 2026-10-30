package clientPackage;

import modelPackage.Operation;
import modelPackage.Resultat;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientCalculateur {
    public static void main(String[] args) {
        try {
            System.out.println("Connexion au serveur de calcul...");
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connecté au serveur !");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            // Création d'une opération (ex: 10 + 5)
            Operation op = new Operation(10, 5, '+');
            oos.writeObject(op);
            oos.flush();

            // Réception du résultat
            Resultat res = (Resultat) ois.readObject();
            System.out.println("Résultat reçu du serveur : " + res.getRes());

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}