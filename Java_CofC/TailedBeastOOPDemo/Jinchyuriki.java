public class Jinchyuriki
{
    private String name;
    private String tailedBeast;
    private int beastNumber;

    public int getBeastNumber(){
        return beastNumber;
    }

    public String getName(){
        return name;
    }

    public String getTailedBeast(){
        return tailedBeast;
    }

    public void setBeastNumber(int newNumber){
        beastNumber = newNumber;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setTailedBeast(String newBeast){
        tailedBeast = newBeast;
    }

    public void PrintTailedBeast(){
        System.out.println(name);
        System.out.print("Fear the power of the ");
        System.out.print(beastNumber);
        System.out.println("-Tailed Beast, ");
        System.out.print(tailedBeast);
        System.out.println("!");
        System.out.println();
    }

    public Jinchyuriki(String newName, String newBeast, int newNumber){
        setName(newName);
        setBeastNumber(newNumber);
        setTailedBeast(newBeast);
    }

    public Jinchyuriki(String newName){
        setName(newName);
    }

    public Jinchyuriki(){}

}