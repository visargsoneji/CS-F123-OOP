public class Triangle extends java.lang.Object
{
    private int base;
    private int height;
    private char colour;

    public Triangle​(int height, int base, char colour)
    {
        this.base = base;
        this.height = height;
        this.colour = colour;
    }

    public int getArea()
    {
        return (this.base*this.height)/2;
    }

    public char getColour​()
    {
        return this.colour;
    }
}
