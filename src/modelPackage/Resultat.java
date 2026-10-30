package modelPackage;
import java.io.Serializable;

public class Resultat implements Serializable {
    private double res;

    public Resultat(double res) {
        this.res = res;
    }

    public double getRes() { return res; }
}