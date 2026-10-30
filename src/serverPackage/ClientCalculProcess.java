package serverPackage;

import modelPackage.Operation;
import modelPackage.Resultat;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientCalculProcess implements Runnable {
    private Socket socket;

    public ClientCalculProcess(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())
        ) {
            // Lire l'opération envoyée par le client
            Operation op = (Operation) ois.readObject();
            System.out.println("Reçu du client " + socket.getRemoteSocketAddress() + " : "
                    + op.getA() + " " + op.getOperateur() + " " + op.getB());

            // Calculer le résultat
            double res = 0;
            switch (op.getOperateur()) {
                case '+': res = op.getA() + op.getB(); break;
                case '-': res = op.getA() - op.getB(); break;
                case '*': res = op.getA() * op.getB(); break;
                case '/': res = op.getA() / op.getB(); break;
            }

            // Incrémenter le compteur global de manière synchronisée
            ServerCalculateurMultiThread.incrementerCompteur();

            // Envoyer le résultat au client
            Resultat resultat = new Resultat(res);
            oos.writeObject(resultat);
            oos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}