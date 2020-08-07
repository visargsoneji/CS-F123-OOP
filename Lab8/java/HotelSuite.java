public class HotelSuite extends java.lang.Object{

    public WashRoom w;
    public LivingRoom l;
    public BedRoom[] br;
    public int totalCost;

    public HotelSuite(WashRoom w, LivingRoom l, BedRoom... br){
        this.totalCost = 0;
        this.w = w;
        this.l = l;
        for(int i=0;i<br.length;i++)
            this.br[i] = br[i];
    }

    public int calculateCost(){
        totalCost = w.getBill() + w.maintenanceCost() + l.getBill() + l.maintenanceCost();
        for(int i=o;i<br.length;i++)
            totalCost += (br[i].getBill() + br[i].maintenanceCost());
        return totalCost;
    }
}
