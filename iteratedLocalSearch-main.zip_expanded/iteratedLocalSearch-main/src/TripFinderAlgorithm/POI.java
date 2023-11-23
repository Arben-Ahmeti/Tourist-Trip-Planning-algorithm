package TripFinderAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class POI implements Cloneable {
	private int ID;
	private long xCoordinate;
	private long yCoordinate;
	private int duration;
	private int score;
	private int openingTime;
	private int closingTime;
	private int entranceFee;
	private ArrayList<Integer> types;

	private boolean isAssigned;
	private int[] lastRemovedIteration;
	private HashMap<Integer, Boolean> alreadyUsedAsAPivot;

	public POI(int ID, long xCoordinate, long yCoordinate, int duration, int score, int openingTime, 
				int closingTime, int entranceFee, ArrayList<Integer> types) {
		this.ID = ID;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.duration = duration;
		this.score = score;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.entranceFee = entranceFee;
		this.types = types;

		alreadyUsedAsAPivot = new HashMap<>();
	}

	public int getID() {
		return this.ID;
	}

	public long getXCoordinate() {
		return this.xCoordinate;
	}

	public long getYCoordinate() {
		return this.yCoordinate;
	}

	public int getDuration() {
		return this.duration;
	}

	public int getScore() {
		return this.score;
	}

	public int getOpeningTime() {
		return this.openingTime;
	}

	public int getClosingTime() {
		return this.closingTime;
	}

	public int getEntranceFee() {
		return this.entranceFee;
	}

	public ArrayList<Integer> getTypes() {
		return this.types;
	}

	public boolean isAssigned() {
		return this.isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

	public void createTabuInfo(int tourCount) {
		lastRemovedIteration = new int[tourCount];
		for(int tour = 0; tour < lastRemovedIteration.length; tour++) {
			lastRemovedIteration[tour] = -3;
		}
	}

	public int getLastRemovedIteration(int tour) {
		return lastRemovedIteration[tour];
	}

	public void updateLastRemovedIteration(int currentIteration, int tour) {
		this.lastRemovedIteration[tour] = currentIteration;
	}

	public boolean hasAlreadyBeenUsedAsAPivotForType(int type) {
		if(this.alreadyUsedAsAPivot.containsKey(type)) {
			return true;
		}
		return false;
	}

	public void setUsedAsPivotForType(int type) {
		this.alreadyUsedAsAPivot.put(type, true);
	}

	@Override
	public String toString() {
		String container = String.format("ID: %d; X: %.3f, Y: %.3f; Duration: %.2f; Score: %.2f; Opens at %.2f; Closes at %.2f; " +
							"Entrance fee: %.2f; Types: ", 
							this.ID, this.xCoordinate / 1000.0f, this.yCoordinate / 1000.0f, this.duration / 100.0f, 
							this.score / 100.0f, this.openingTime / 100.0f, this.closingTime / 100.0f,
							this.entranceFee / 100.0f);
		for(int index = 0; index < types.size(); index++) {
			container += types.get(index);
			if(index != types.size() - 1) {
				container += ", ";
			}
		}
		container += ".";
		return container;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		POI clonedPOI = (POI)super.clone();
		return clonedPOI;
	}
}
