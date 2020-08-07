public class InvalidDimensionException extends java.lang.Exception{

    private int length;
    private int width;
    private int height;

    public InvalidDimensionException(int length, int width, int height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public java.lang.String getMessage(){
        String s = null;
        if(this.length < 1)
            s = "Length value is invalid.";
        else if(this.width < 1)
            s = "Width value is invalid.";
        else if(this.height < 1)
            s = "Height value is invalid";
        return s;
    }
}
