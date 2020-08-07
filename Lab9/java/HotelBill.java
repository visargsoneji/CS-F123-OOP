import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class HotelBill extends java.lang.Object{
    private java.lang.String filename;
    private Hotel hotel;
    private static int MAX_NUMBER_OF_HOTEL_SUITES= 3;
    private static int MAX_NUMBER_OF_BED_ROOMS = 5;

    public HotelBill(java.lang.String filename){
        this.filename = filename;
    }

    public int getCost(){
        if(this.hotel == null)
            return -1;
        else
            return this.hotel.getHotelCost();
    }

    public int readContent(){

        HotelSuite[] hs = new HotelSuite[MAX_NUMBER_OF_HOTEL_SUITES];
        WashRoom w = null;
        LivingRoom l = null;
        BedRoom[] b = null;
        int hotelSuiteCount = 0;
        int bedroomCount = 0;
        int flag = 0;

        try{
            //BufferedReader br = new BufferedReader(new FileReader(this.filename));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.filename), StandardCharsets.UTF_8));
            String line;
            int numlines=0;
            while ((line = br.readLine()) != null){
                if(line.equals("HotelSuite:"))
                {
                    if(flag == 1)
                        hs[hotelSuiteCount++] = new HotelSuite(w,l,b);

                    flag = 1;
                    b = new BedRoom[MAX_NUMBER_OF_BED_ROOMS];
                    bedroomCount = 0;
                }
                else
                {
                    String s[] = line.split(",");
                    String roomName[] = s[0].split(":");

                    if(roomName[1].equals("lr"))
                        l = new LivingRoom(Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]));
                    else if(roomName[1].equals("wr"))
                        w = new WashRoom(Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]));
                    else if(roomName[1].equals("br"))
                        b[bedroomCount++] = new BedRoom(Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]));
                }
            }
            hs[hotelSuiteCount++] = new HotelSuite(w,l,b);
            br.close();
            this.hotel = new Hotel(hs);
            return hotelSuiteCount;
        }
        catch(IOException ex){
            System.out.println(ex.toString());
            this.hotel = null;
            return -1;
        }
    }

    public void writeResult(java.lang.String content) {
        try{
            //BufferedWriter bw = new BufferedWriter(new FileWriter(this.filename, true));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.filename, true), StandardCharsets.UTF_8));

            bw.newLine();
            bw.write(content);
            bw.close();
        }
        catch(IOException ex){
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();

        HotelBill hb = new HotelBill(file);

        int hotelSuiteC = hb.readContent();
        System.out.println(hotelSuiteC);

        int cost = hb.getCost();
        System.out.println(cost);
        hb.writeResult(String.valueOf(cost));
    }

}
