package Dati;

public class Ipasibas {
    public int ID;
    public String Vards;
    public String uzvards;
    public int[] atzimes;
    public int galaAtzime;
    public int galaVertejums;

    public Ipasibas(int ID,String vards,String uzvards,int[] atzimes,int galaAtzime,int galaVertejums){
        this.ID = ID;
        this.Vards = vards;
        this.uzvards = uzvards;
        this.atzimes = atzimes;
        this.galaAtzime = galaAtzime;
        this.galaVertejums = galaVertejums;
    }
    public String toString(){

        return ID + " " +  Vards + " " + uzvards + " " + atzimes[0] + " "
                + " " + atzimes[1] + " " + atzimes[2] + " "+ atzimes[3] + " "+ galaAtzime + " "+ galaVertejums;
    }
}
