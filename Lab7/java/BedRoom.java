public class BedRoom extends Room implements IOperatingCost{
    private Bed bed;
    private boolean acState;
    private boolean sleepState;
    private int electricityBill;

    public BedRoom​(int roomLength,int roomWidth,int roomHeight,Bed bed){
        super(roomLength, roomWidth, roomHeight);
        this.acState = false;
        this.sleepState = false;
        this.electricityBill = 0;
        this.bed = bed;
    }

    public boolean getSleepState(){
        return sleepState;
    }

    public boolean getAcState(){
        return acState;
    }

    public int maintenanceCost(){
        return this.bed.getCost();
    }

    public int getBill(){
        return electricityBill;
    }

    public void use​(java.lang.String name){
        if(name.equals("AC"))
        {
            if(!acState)
            {
                acState = true;
                electricityBill += 10*this.getVolume();
            }
            else
                acState = false;
        }
        if(name.equals("Bed"))
        {
            if(sleepState)
                sleepState = false;
            else
                sleepState = true;
        }
    }
}
