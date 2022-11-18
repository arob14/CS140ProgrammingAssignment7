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
	
	public ArrayList<CarFunctions> getCarList() {
		ArrayList<CarFunctions> tempCarList = new ArrayList<>();
		for (int i = 0; i < carList.size(); i++) {
			tempCarList.add(carList.get(i));
		}
		return tempCarList;
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
}
