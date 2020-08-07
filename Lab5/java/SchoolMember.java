public class SchoolMember extends java.lang.Object{
    private String name;
    private String address;
    private int chanceOfPromotion;

    public SchoolMember(String name, String address)
    {
        this.name = name;
        this.address = address;
    }

    protected void setChanceOfPromotion​(int chance){
        this.chanceOfPromotion = chance;
    }

    public String toString(){
        String s = (this.name + " (" + this.address + ")");
        return s;
    }

    public int promoted(){
        return chanceOfPromotion;
    }
}
