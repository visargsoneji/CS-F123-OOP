public class Shape extends java.lang.Object{

    private int squareCount;
    private Square[] squarelist;
    private int triangleCount;
    private Triangle[] trianglelist;

    public Shape​()
    {
        this.squareCount = 0;
        this.triangleCount = 0;
        this.squarelist = new Square[10];
        this.trianglelist = new Triangle[10];
    }

    public char getColourOfMaxSquare​()
    {
        int max_area = 0,temp;
        char max_colour = 'N';
        for(int i=0; i<this.squarelist.length; i++)
        {
            temp = squarelist[i].getArea();
            if(temp > max_area)
            {
                max_area = temp;
                max_colour = squarelist[i].getColour();
            }
        }
        return max_colour;
    }

    public char getColourOfMaxTriangle​()
    {
        int max_area = 0,temp;
        char max_colour = 'N';
        for(int i=0; i<this.trianglelist.length; i++)
        {
            temp = trianglelist[i].getArea();
            if(temp > max_area)
            {
                max_area = temp;
                max_colour = trianglelist[i].getColour();
            }
        }

        return max_colour;
    }

    public int getSquareCount​()
    {
        return this.squareCount;
    }

    public int getTriangleCount​()
    {
        return this.triangleCount;
    }

    public boolean insertSquare​(Square square)
    {
        if(this.getSquareCount​() == 10)
            return false;

        squarelist[this.getSquareCount​()] = square;
        this.squareCount++;
        return true;

    }

    public boolean insertTriangle​(Triangle triangle)
    {
        if(this.getTriangleCount​() == 10)
            return false;

        trianglelist[this.getTriangleCount​()] = triangle;
        this.triangleCount++;
        return true;
    }
}
