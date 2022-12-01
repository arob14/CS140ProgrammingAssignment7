import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.StringTokenizer;

class roberts_ManageCarData implements ManageCarDataFunctions
{
	ArrayList<CarFunctions> carList;
	PriorityQueue<CarFunctions> carListByTotalRange;
	PriorityQueue<CarFunctions> carListByRemainingRange;
	public roberts_ManageCarData() {
		this.carList = new ArrayList<>();
		this.carListByTotalRange = new PriorityQueue<>(new TotalRangeComparator());
		this.carListByRemainingRange = new PriorityQueue<>(new RemainingRangeComparator());
	}

	public void readData(String filename) {
		try {
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String inn;
			while ((inn = input.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(inn, "\t");
				String id = st.nextToken();
				int fuelEconomy = Integer.parseInt(st.nextToken());
				int fuelCapacity = Integer.parseInt(st.nextToken());
				double remainingFuel = Double.parseDouble(st.nextToken());
				CarFunctions c = new roberts_Car(id, fuelEconomy, fuelCapacity, remainingFuel);
				
				carList.add(c);
				carListByTotalRange.add(c);
				carListByRemainingRange.add(c);
			}
		}
		catch (Exception e) {

		}
	}

	public ArrayList<CarFunctions> getCarList() {
		ArrayList<CarFunctions> tempCarList = new ArrayList<>();
		for(CarFunctions currentCar : carList) {
			tempCarList.add(currentCar);
		}
		return tempCarList;
	}

	public PriorityQueue<CarFunctions> getCarListByTotalRange() {
		PriorityQueue<CarFunctions> tempCarListByTotalRange= new PriorityQueue<>(new TotalRangeComparator());
		tempCarListByTotalRange.addAll(carList);
		return tempCarListByTotalRange;
	}


	public ArrayList<CarFunctions> getCarListByTotalRangeUsingIterator() {
		ArrayList<CarFunctions> tempCarList = new ArrayList<>();
		Iterator<CarFunctions> it = carListByTotalRange.iterator();
		while (it.hasNext()) {
			tempCarList.add(it.next());
		}
		return tempCarList;
	}

	public PriorityQueue<CarFunctions> getCarListByRemainingRange() {
		PriorityQueue<CarFunctions> tempCarListByRemainingRange= new PriorityQueue<>(new RemainingRangeComparator());
		tempCarListByRemainingRange.addAll(carList);
		return tempCarListByRemainingRange;
	}

	public ArrayList<CarFunctions> getCarListByRemainingRangeUsingIterator() {
		ArrayList<CarFunctions> tempCarList = new ArrayList<>();
		Iterator<CarFunctions> it = carListByRemainingRange.iterator();
		while (it.hasNext()) {
			tempCarList.add(it.next());
		}
		return tempCarList;
	}

	public ArrayList<String> getCarListByTotalRangeViaPoll(double minTotalRange, double maxTotalRange) {
		ArrayList<String> tempCarList = new ArrayList<>();
		PriorityQueue<CarFunctions> tempCarListByTotalRange = getCarListByTotalRange();
		for(int i = 0; i < carList.size(); i++) {
			CarFunctions currentCar = tempCarListByTotalRange.poll();
			String currentCarString = currentCar.toString();
			String index = "";
			String sameEconomy = "";
			if (currentCar.getTotalRangeInMiles() >= minTotalRange && currentCar.getTotalRangeInMiles() <= maxTotalRange) {
				for(int j = 0; j < carList.size(); j++) {
					if (carList.get(j).equals(currentCar)) {
						index += "\t" + j;
					}
					if(currentCar.getFuelEconomyInMilesPerGallon() == carList.get(j).getFuelEconomyInMilesPerGallon()) {
						sameEconomy += "\t" + j;
					}
				}
				currentCarString += index + sameEconomy;
				tempCarList.add(currentCarString);
			}
		}
		return tempCarList;
	}

	public ArrayList<String> getCarListByRemainingRangeViaPoll(double minRemainingRange, double maxRemainingRange) {
		ArrayList<String> tempCarList = new ArrayList<>();
		PriorityQueue<CarFunctions> tempCarListByRemainingRange = getCarListByRemainingRange();
		for(int i = 0; i < carList.size(); i++) {
			CarFunctions currentCar = tempCarListByRemainingRange.poll();
			String currentCarString = currentCar.toString();
			String index = "";
			String sameEconomy = "";
			if (currentCar.getRemainingRangeInMiles() >= minRemainingRange && currentCar.getRemainingRangeInMiles() <= maxRemainingRange) {
				for(int j = 0; j < carList.size(); j++) {
					if (carList.get(j).equals(currentCar)) {
						index += "\t" + j;
					}
					if(currentCar.getFuelEconomyInMilesPerGallon() == carList.get(j).getFuelEconomyInMilesPerGallon()) {
						sameEconomy += "\t" + j;
					}
				}
				currentCarString += index + sameEconomy;
				tempCarList.add(currentCarString);
			}
		}
		return tempCarList;
	}
}
