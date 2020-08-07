public class PartTimeStudent extends Student{

    public PartTimeStudent(String name, String address, int credits){
        super(name, address);
        super.minCredits = credits;
    }

    public java.lang.String toString(){
        String s = ("PartTime"+super.toString());
        return s;
    }

}
