public class Hotel extends java.lang.Object{

    public HotelSuite[] hotelroom;

    public Hotel(HotelSuite... hotelroom){
        for(int i=0;i<hotelroom.length;i++)
            this.hotelroom[i] = hotelroom[i];
    }

    public int getHotelCost(){
        int cost=0;
        for(int i=0;i<hotelroom.length;i++)
            cost += hotelroom[i].calculateCost();
        return cost;
    }
}
