public class Triangle extends java.lang.Object{

    private int height;
    private int base;
    private static int countTriangle = 0;

    public Triangle(int height, int base){
        this.height = height;
        this.base = base;
        this.countTriangle += 1;
    }

    public boolean isEnough(){
        return (this.countTriangle >= 5);
    }

    public boolean isEnough(int enoughNumber){
        return (this.countTriangle >= enoughNumber);
    }
}
