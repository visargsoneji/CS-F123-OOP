public class Colony extends java.lang.Object{
    private House[] houses;
    private int numberOfHouses;

    public Colony(){
        this.numberOfHouses = 0;
        houses = new House[10];
    }

    public boolean addHouse​(House house){
        if(this.numberOfHouses < 10)
        {
            houses[this.numberOfHouses++] = house;
            return true;
        }
        else return false;
    }

    public int getNumberOfHouses(){
        return this.numberOfHouses;
    }

    public int goodWalls(){
        int gw = 0;
        /*for(int i=0;i<this.numberOfHouses;i++)
        {
            for(int j=0;j<houses[i].getCountRooms();j++)
            {
                for(int k=0;k<6;k++)
                {
                    if(houses[i].rooms[j].walls[k].getWallCondition() == 'g')
                        gw++;
                }
            }
        }*/
        for(int i=0;i< this.numberOfHouses;i++)
        {
            gw += (houses[i].getCountRooms()*6 - houses[i].getBadWalls())
        }

        return gw;
    }

    public int getRevenue(){
        int revenue=0;
        for(int i=0;i<this.numberOfHouses;i++)
            revenue += houses[i].getRent();

        return revenue;
    }
}
