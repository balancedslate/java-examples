public class Kyuubi extends Jinchyuriki {

    public Kyuubi(){
        super.setName("Uzumaki Naruto!");
        super.setTailedBeast("Kuruma");
        super.setBeastNumber(9);
    }

    private String catchphrase = "Dattebyou!";

    private String rival = "Uchiha Sasuke";

    public String getCatchphrase(){
        return catchphrase;
    }

    public String getRival(){
        return rival;
    }

    public void PrintTailedBeast(){
        super.PrintTailedBeast();
        System.out.println(getCatchphrase());
        System.out.print("One day, I'll get you, ");
        System.out.print(rival);
        System.out.println("!");
        System.out.println();
    }

}