package Logika;
import Dati.Ipasibas;
import Dati.Studenti;
import java.util.Collections;

public class Aprēkini {
    public static int GalaVērtējums(int[] atzimes, int galaAtzime) {
        int galaVertejums = galaAtzime;
        for (int i = 0; i < atzimes.length; i++) {
            galaVertejums = galaVertejums + atzimes[i];
        }
        galaVertejums = galaVertejums / (atzimes.length + 1);
        if (galaAtzime == galaVertejums + 1) {
            return galaAtzime;
        }
        return galaVertejums;
    }
    public static void KartotPecGalaVertejums() {
        for (int j = Studenti.saraksts.size() - 1; j > 0; j--) {
            for (int i = 1; i < Studenti.saraksts.size(); i++) {
                if (Studenti.saraksts.get(i - 1).galaVertejums < Studenti.saraksts.get(i).galaVertejums) {
                    Collections.swap(Studenti.saraksts, i - 1, i);
                }
            }
        }
    }
    public static void KartotPecGalaAtzimes() {
        for (int j = Studenti.saraksts.size() - 1; j > 0; j--) {
            for (int i = 1; i < Studenti.saraksts.size(); i++) {
                if (Studenti.saraksts.get(i - 1).galaAtzime < Studenti.saraksts.get(i).galaAtzime) {
                    Collections.swap(Studenti.saraksts, i - 1, i);
                }
            }
        }
    }
    public static void KartotPecNumura() {
        for (int j = Studenti.saraksts.size() - 1; j > 0; j--) {
            for (int i = 1; i < Studenti.saraksts.size(); i++) {
                if (Studenti.saraksts.get(i - 1).ID > Studenti.saraksts.get(i).ID) {
                    Collections.swap(Studenti.saraksts, i - 1, i);
                }
            }
        }
    }
    public static Ipasibas LabakaisStudent(){
        KartotPecGalaAtzimes();
        return Studenti.saraksts.get(0);
    }
    public static Ipasibas SliktakaisStudent(){
        KartotPecGalaAtzimes();
        return Studenti.saraksts.get(Studenti.saraksts.size()-1);
    }
}