import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

class roberts_Car implements CarFunctions
{
	private final String id;
	private final int fuelEconomyInMilesPerGallon;
	private final int fuelCapacityInGallons;
	private double currentFuelInGallons;

	public roberts_Car(String id, int fuelEconomyInMilesPerGallon, int fuelCapacityInGallons,
			double currentFuelInGallons) {
		this.id = id;
		this.fuelEconomyInMilesPerGallon = fuelEconomyInMilesPerGallon;
		this.fuelCapacityInGallons = fuelCapacityInGallons;
		this.currentFuelInGallons = currentFuelInGallons;
	}

	public double getCurrentFuelInGallons() {
		return currentFuelInGallons;
	}

	public void setCurrentFuelInGallons(double currentFuelInGallons) {
		this.currentFuelInGallons = currentFuelInGallons;
	}

	public String getId() {
		return id;
	}

	public int getFuelEconomyInMilesPerGallon() {
		return fuelEconomyInMilesPerGallon;
	}

	public int getFuelCapacityInGallons() {
		return fuelCapacityInGallons;
	}

	public String toString()
	{
		return getId() + "\t" + getFuelEconomyInMilesPerGallon() + "\t" + getFuelCapacityInGallons() + "\t" + getCurrentFuelInGallons() + "\t" + getTotalRangeInMiles() + "\t" + getRemainingRangeInMiles();
	}
}
