public class Hanabi extends Jinchyuriki {
    
    public Hanabi(){
        super.setName("Killer Bee!");
        super.setTailedBeast("Gyuuki");
        super.setBeastNumber(8);
    }
    
    private String catchphrase = "Bakayarou, Konoyarou!";

    public String getCatchphrase(){
        return catchphrase;
    }

    public void PrintTailedBeast(){
        super.PrintTailedBeast();
        System.out.println(getCatchphrase());
        System.out.println();
    }

}
