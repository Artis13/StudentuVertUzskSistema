package Dati;
import java.util.ArrayList;
import java.util.List;

public class Studenti {

   public static List<Ipasibas> saraksts;


    public Studenti(){
       saraksts = new ArrayList<>();
   }

    public static void pievienotStudentu(int ID,String vards,String uzvards,int[] atzimes,int galaAtzime,int galaVertejums){

       saraksts.add(new Ipasibas(ID,vards,uzvards,atzimes,galaAtzime,galaVertejums));
    }
    public static Ipasibas atrastStudentu (int ID){
        for(Ipasibas x : saraksts){
            if(x.ID==ID){
                return x;
            }
        }
        return null;
    }
    public static void DzestStudentu(int ID){
        saraksts.remove(atrastStudentu(ID));
    }
}
