public abstract class Room extends java.lang.Object implements IRoom{
    protected int roomLength;
    protected int roomWidth;
    protected int roomHeight;

    public Room​(int roomLength, int roomWidth, int roomHeight){
        this.roomHeight = roomHeight;
        this.roomWidth = roomWidth;
        this.roomLength = roomLength;
    }

    protected int getVolume(){
        return this.roomWidth*this.roomHeight*this.roomLength;
    }

    protected int getSurfaceArea(){
        return 2*(roomLength*roomHeight + roomLength*roomWidth + roomHeight*roomWidth);
    }

    public abstract int getBill();
}
