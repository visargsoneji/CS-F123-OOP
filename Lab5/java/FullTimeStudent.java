public class FullTimeStudent extends Student{

    public FullTimeStudent(String name, String address, int credits){
        super(name, address);
        super.minCredits = credits;
    }

    public java.lang.String toString(){
        String s = ("FullTime"+super.toString());
        return s;
    }
}
