import java.util.ArrayList;

public class Juubi {
    public static void main(String args[]){
        Jinchyuriki Konoha = new Kyuubi();
        Jinchyuriki CloudVillage = new Hanabi();
        Jinchyuriki SandVillage = new Jinchyuriki("Gaara", "Shikaku", 1);
        Jinchyuriki RainVillage = new Jinchyuriki("Utakata", "Isobu", 7);

        ArrayList<Jinchyuriki> tenTails = new ArrayList<Jinchyuriki>();

        Jinchyuriki Mizukage = new Jinchyuriki();
        Mizukage.setBeastNumber(3);

        Jinchyuriki fiveTails = new Jinchyuriki("Han", "Kokoe", 5);
        Jinchyuriki fourTails = new Jinchyuriki("Roshi", "Son Goku", 4);

        Jinchyuriki HiddenMist = new Jinchyuriki("Fuu", "Unahana", 6);

        tenTails.add(SandVillage);
        tenTails.add(Mizukage);
        tenTails.add(fourTails);
        tenTails.add(fiveTails);
        tenTails.add(HiddenMist);
        tenTails.add(RainVillage);
        tenTails.add(CloudVillage);

        Konoha.PrintTailedBeast();

        PrintTenTails(tenTails);

    }

    public static void PrintTenTails(ArrayList<Jinchyuriki> TenTails){
        for (Jinchyuriki jinchyuriki : TenTails) {
            jinchyuriki.PrintTailedBeast();
        }
    }

}