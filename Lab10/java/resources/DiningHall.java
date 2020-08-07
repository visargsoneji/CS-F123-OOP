package resources;
/**
 * This represents the Dining Hall where guests staying in a hotel will come to
 * eat.
 *
 * @author Ronak, Kunal, Hrishikesh, Alish
 * @version 20-November, 2018
 *
 */
public class DiningHall {

	/**
	 * Number of seats empty in the Dining Hall at a given time.
	 */
	private int seatsAvailable;

	/**
	 * Maximum number of seats in the Dining Hall.
	 */
	private int maxCapacity;

	/**
	 * Total number of people who have finished eating and left the Dining Hall.
	 */
	private int peopleServed;

	public DiningHall​(int maxCapacity){
		this.maxCapacity = maxCapacity;
		this.peopleServed = 0;
		this.seatsAvailable = maxCapacity;
	}

	/**
	 * Return the number of seats available.
	 *
	 * @return Number of empty seats.
	 */

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public synchronized boolean enterDiningHall(){
		if(this.getSeatsAvailable() > 0){
			this.seatsAvailable--;
			return true;
		}
		else
			return false;
	}

	public synchronized void exitDiningHall(){
		if(this.seatsAvailable < this.maxCapacity){
			this.seatsAvailable++;
			this.peopleServed++;
		}
	}

	/**
	 * Return the number of People Served.
	 *
	 * @return Number of peopleServed
	 */
	public int getPeopleServed() {
		return peopleServed;
	}

}
