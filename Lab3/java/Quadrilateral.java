public class Quadrilateral extends java.lang.Object{
    private int[] edge;

    /*public Quadrilateral(){
        this.edge[0] = this.edge[1] = this.edge[2] = this.edge[3] = 0;
    }*/

    public Quadrilateral(int edge){
        this.edge[0] = this.edge[1] = this.edge[2] = this.edge[3] = edge;
    }

    public Quadrilateral(int length, int breadth){
        this.edge[0] = this.edge[1] = length;
        this.edge[2] = this.edge[3] = breadth;
    }

    public Quadrilateral(int edge1, int edge2, int edge3, int edge4){
        this.edge[0] = edge1;
        this.edge[1] = edge2;
        this.edge[2] = edge3;
        this.edge[3] = edge4;
    }

    @Override
    public boolean equals(java.lang.Object obj){
        if(this == obj)
            return true;

        if(obj == null || obj.getClass() != this.getClass())
            return false;

        Quadrilateral quad = (Quadrilateral) obj;

        return (this.getPerimeter() == quad.getPerimeter());
    }

    @Override
    public int hashCode(){
        return (17*37 + this.edge.hashCode());
    }

    public int getPerimeter(){
        int perimeter = 0;
        for (int i=0; i<4; i++) {
            perimeter += this.edge[i];
        }
        return perimeter;
    }
}
