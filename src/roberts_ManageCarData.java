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
		ArrayList<CarFunctions> tempCarList = new ArrayList<>(carList);
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
		return ManageCarDataFunctions.super.getCarListByTotalRangeViaPoll(minTotalRange, maxTotalRange);
	}

	public ArrayList<String> getCarListByRemainingRangeViaPoll(double minRemainingRange, double maxRemainingRange) {
		return ManageCarDataFunctions.super.getCarListByRemainingRangeViaPoll(minRemainingRange, maxRemainingRange);
	}
}
