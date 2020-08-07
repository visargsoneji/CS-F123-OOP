package simulator;
import resources.*;
/**
 * This class uses the classes in the Resources package to simulate tourists
 * coming to the city.
 *
 * @author Ronak, Kunal, Hrishikesh, Alish
 * @version 20-November, 2018
 *
 */
public class City {

	/**
	 * A Hotel with three star rating.
	 */
	public Hotel threeStarHotel;

	/**
	 * A Hotel with four star rating.
	 */
	public Hotel fourStarHotel;

	/**
	 * A Hotel with five star rating.
	 */
	public Hotel fiveStarHotel;

	/**
	 * A DiningHall
	 */
	public DiningHall diningHall;

	/**
	 * An array of Guests.
	 */
	public Guest[] guests;

	/**
	 * An array of Threads which are to be initialized with the guests.
	 */
	public Thread[] threads;

	public City​(int numberOfRoomsInEachHotel,
            int baseRate,
            int diningHallCapacity,
            int[] wealth,
            int[] minHotelPreference){
		int size = wealth.length;
		this.guests = new Guest[size];
		this.threads = new Thread[size];
		for(int i=0;i<size;i++){
			this.threads[i] = new Thread();
			this.guests[i] = new Guest(wealth[i], minHotelPreference[i]);
		}
		this.threeStarHotel = new Hotel(3, numberOfRoomsInEachHotel, 3*baseRate);
		this.fourStarHotel = new Hotel(4, numberOfRoomsInEachHotel, 4*baseRate);
		this.fiveStarHotel = new Hotel(5, numberOfRoomsInEachHotel, 5*baseRate);
		this.diningHall = new DiningHall(diningHallCapacity);
	}

	public void simulateCity(){
		for(int i=0;i<guests.length;i++){
			guests[i].initResources​(threeStarHotel, fourStarHotel, fiveStarHotel, diningHall);
			String threadname = "Guest " + threads[i].getId();
			threads[i].setName(threadname);
			threads[i].start();
		}
		for(int i = 0;i<threads.length;i++){
			try{
			    threads[i].start();
				threads[i].join();
			}
			catch(InterruptedException ex) {}
		}

	}

}
