package Aplikacija;
import Dati.Studenti;
import Dati.Ipasibas;
import Logika.Aprēkini;

import java.util.Scanner;

public class Funkcijas {
    public Funkcijas(){
        Studenti st = new Studenti();
    }
    int ID = 1000;
    Scanner scanner = new Scanner(System.in);
    public void Izvelne(){
        System.out.println("0.Pārtraukt darbu ");
        System.out.println("1.Pievienot jaunu studentu ");
        System.out.println("2.Dzēst studentu ");
        System.out.println("3.Atjaunot studenta datus ");
        System.out.println("4.Apskatīt visu studentu sarakstu ");
        System.out.println("5.Izveidot pārskatu par studentu vidējām atzīmēm ");
        System.out.println("6.Izveidot pārskatu par studentu gala vērtējumiem");
        System.out.println("7.Parādīt datus par studentu(-iem), ar visaugstāko(-ajiem) vērtējumiem ");
        System.out.println("8.Parādīt datus par studentu(-iem), ar viszemāko(-ajiem) vērtējumiem ");
        System.out.println("9.Atrast studentu pēc ID");
    }
    public void PievienotStudentu(){

        System.out.println("Ievadiet studenta vārdu ");
        String vards = scanner.next();
        System.out.println("Ievadiet studenta Uzvārdu ");
        String uzvards = scanner.next();

        System.out.println("Ievadiet 4 studenta semstra vērtējumus ");

        int[] atzimes = new int[4];

        for (int i =0;i<4;i++){
            if (i==0){
                System.out.println("Ievadiet pirmo atzīmi ");
                atzimes[0] = scanner.nextInt();
            }
            else {
                System.out.println("Ievadiet nākošo atzīmi ");
                atzimes[i] = scanner.nextInt();
            }
        }

         System.out.println("Ievadiet studenta gala atzīmi ");
         int galaAtzime = scanner.nextInt();
         int galaVertejums = Aprēkini.GalaVērtējums(atzimes,galaAtzime);

        Studenti.pievienotStudentu(ID,vards,uzvards,atzimes,galaAtzime,galaVertejums);
        ID++;
    }
    public void AtjaunotStudentaDatus(){
        System.out.println("Ievadiet studenta ID numuru?");
        int ID = scanner.nextInt();
        Ipasibas st = Studenti.atrastStudentu(ID);
        if (st==null){
            System.out.println("Students netika atrasts ");
        }
        else {
            System.out.println("Students tika atrasts. Varat veikt izmainas. Lai neveiktu izmainas nospiediet enter.");

            System.out.println("Ievadiet studenta vārdu ");
            System.out.println(scanner.nextLine());
            String vards = scanner.nextLine();
            if (vards.equals("")){
                vards = st.Vards;
            }
            System.out.println("Ievadiet studenta Uzvārdu ");
            String uzvards = scanner.nextLine();
            if (uzvards.equals("")){
                uzvards = st.uzvards;
            }
            System.out.println("Ievadiet 4 studenta semstra vērtējumus ");
            int[] atzimes = new int[4];
            for (int i =0;i<4;i++){
                if (i==0){
                    System.out.println("Ievadiet pirmo atzīmi ");
                    String atzime = scanner.nextLine();
                    if (atzime.equals("")){
                        atzimes[0] = st.atzimes[0];
                    }
                    else {
                        atzimes[0] = Integer.parseInt(atzime);
                    }
                }
                else {
                    System.out.println("Ievadiet nākošo atzīmi ");
                    String atzime = scanner.nextLine();
                    if (atzime.equals("")){
                        atzimes[i] = st.atzimes[0];
                    }
                    else {
                        atzimes[i] = Integer.parseInt(atzime);
                    }
                }
            }
            System.out.println("Ievadiet studenta gala atzīmi ");
            String GalaAtzAtbilde = scanner.nextLine();
            int Galaatzime;
            if (GalaAtzAtbilde.equals("")){
                Galaatzime = st.galaAtzime;
            }
            else {
                Galaatzime = Integer.parseInt(GalaAtzAtbilde);
            }

            Studenti.DzestStudentu(ID);
            int galaVertejums = Aprēkini.GalaVērtējums(atzimes,Galaatzime);
            Studenti.pievienotStudentu(ID,vards,uzvards,atzimes,Galaatzime,galaVertejums);
            System.out.println("Studenta dati veiksmigi atjaunoti ");
        }
    }
    public void Atraststudentu(){
        System.out.println("Ievadiet studenta ID numuru?");
        int ID = scanner.nextInt();
        if (Studenti.atrastStudentu(ID)==null){
            System.out.println("Students netika atrasts ");
        }
        else{
            System.out.println(Studenti.atrastStudentu(ID).toString());


    }
}
    public void DzestStudentu(){
        System.out.println("Ievadiet studenta ID numuru?");
        int ID = scanner.nextInt();
        if (Studenti.atrastStudentu(ID)==null){
            System.out.println("Students netika atrasts ");
        }
        else{
            Studenti.DzestStudentu(ID);
            System.out.println("Students tika izdzests");
        }
    }
    public void drukatSarakstu(){

        System.out.printf(" %n  %-8s  %-12s   %-12s   %-2s   %-2s  %-2s  %-2s   %-7s  %-6s ",
                "ID","Vards","Uzvards","#1","#2","#3","#4","Gala atzime","Gala vertejums");

        for (Ipasibas x: Studenti.saraksts){
            System.out.printf(" %n  %-8s  %-12s   %-12s   %-2s   %-2s  %-2s  %-2s   %-12s  %-12s ",
                    x.ID,x.Vards,x.uzvards,x.atzimes[0],x.atzimes[1],x.atzimes[2],x.atzimes[3],x.galaVertejums,x.galaAtzime);
        }
    }
    public void LabakaisStudents(){
        Ipasibas x = Aprēkini.LabakaisStudent();
        System.out.printf(" %n  %-8s  %-12s   %-12s   %-2s   %-2s  %-2s  %-2s   %-7s  %-6s ",
                "ID", "Vards","Uzvards","#1","#2","#3","#4","Gala atzime","Gala vertejums");

        System.out.printf(" %n  %-8s  %-12s   %-12s   %-2s   %-2s  %-2s  %-2s   %-12s  %-12s ",
                x.ID,x.Vards,x.uzvards,x.atzimes[0],x.atzimes[1],x.atzimes[2],x.atzimes[3],x.galaVertejums,x.galaAtzime);
    }
    public void SliktakaisStudents(){
        Ipasibas x = Aprēkini.SliktakaisStudent();
        System.out.printf(" %n  %-8s  %-12s   %-12s   %-2s   %-2s  %-2s  %-2s   %-7s  %-6s ",
                "ID", "Vards","Uzvards","#1","#2","#3","#4","Gala atzime","Gala vertejums");

        System.out.printf(" %n  %-8s  %-12s   %-12s   %-2s   %-2s  %-2s  %-2s   %-12s  %-12s ",
                x.ID,x.Vards,x.uzvards,x.atzimes[0],x.atzimes[1],x.atzimes[2],x.atzimes[3],x.galaVertejums,x.galaAtzime);
    }
    public void KartotPecGalaVertejums(){
        Aprēkini.KartotPecGalaVertejums();
    }
    public void KartotPecGalaAtzimes(){
        Aprēkini.KartotPecGalaAtzimes();
    }
    public void KartotPecNumura (){
        Aprēkini.KartotPecNumura();
    }
}
