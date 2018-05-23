package Aplikacija;
import java.util.Scanner;

public class Aplikacija {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Funkcijas f = new Funkcijas();
        String at;
        while (true){
            System.out.println("Izvēlieties kādu darbību vēlaties veikt?");
            f.Izvelne();
            at = scanner.next();
            if (at.equals("0")) break;
            else if (at.equals("1")) f.PievienotStudentu();
            else if(at.equals("2")) f.DzestStudentu();
            else if (at.equals("3")) f.AtjaunotStudentaDatus();
            else if (at.equals("4")){
                f.KartotPecNumura();
                f.drukatSarakstu();
            }
            else if (at.equals("5")) {
                f.KartotPecGalaAtzimes();
                f.drukatSarakstu();
            }
            else if (at.equals("6")) {
                f.KartotPecGalaVertejums();
                f.drukatSarakstu();
            }
            else if(at.equals("7")){
                f.LabakaisStudents();
            }
            else if(at.equals("8")){
                f.SliktakaisStudents();
            }
            else if (at.equals("9")) f.Atraststudentu();
            else {
                System.out.println("Darbība netika atpazīta");
            }
            System.out.println();
        }


    }
}
