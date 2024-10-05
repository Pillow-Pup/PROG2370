package myPackage;

import java.util.*;

public class Runner {
	static int counter = 0;
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Car c1 = new Car(++counter,"Honda","White");
		Car c2 = new Car(++counter,"Kia","Red");
		Car c3 = new Car(++counter,"Jeep","Purple");
		Car c4 = new Car(++counter,"Honda","Red");
		Car c5 = new Car(++counter,"Dodge","Purple");
		
		Car c6 = new Car(++counter,"Ford","Black");
		
		// create an empty list of Car objects
		List<Car> cars = new ArrayList<>();
		// add the cars to the list
		cars.add(c1);cars.add(c2);cars.add(c3);cars.add(c4);cars.add(c5);cars.add(c6);
		
		// simple, un-optimized approach
		getCountByColour(cars);
		
		// optimized
		getCountByColourOptimized(cars);
	}

	private static void getCountByColourOptimized(List<Car> cars) { // key=white, value=1
		// create a hashmap
		//string = colour, Integer = count
		Map<String, Integer> map = new HashMap<>();
		
		// populate the map
		for(int i=0; i<cars.size(); i++) {
			Car currentCar = cars.get(i);
			String carColour = currentCar.getColour();
			
			if(!map.containsKey(carColour)) { // does map already contain colour? if not, add the key/colour & initialize the value
				map.put(carColour, 1);
			}
			else {
				// key already exists, so incrememt the value
				int count = map.get(carColour);
				++count;
				map.put(carColour, count);
			}
		}
		
		// print the map
		System.out.println(map);
		
		for(Map.Entry<String, Integer>me:map.entrySet()) {
			String colour = me.getKey();
			int count = me.getValue();
			System.out.print(colour+": "+count+", ");
		}
			
	}

	private static void getCountByColour(List<Car> cars) { // white: 1, red: 2, purple: 3 (2purple, 1black)
		// simple approach
		int whiteCount = 0;
		int redCount = 0;
		int purpleCount = 0;
		
		for(Car car : cars) {
			if(car.getColour().equals("White")) {
				whiteCount++;
			}
			else if(car.getColour().equals("Red")) {
				redCount++;
			}
			else {
				purpleCount++;
			}
		}
		
		System.out.println("White: "+whiteCount+", Red: "+redCount+", Purple: "+purpleCount);		
	}
}

class Car{
	private int id;
	private String name;
	private String colour;
	
	// constructor
	public Car(int id, String name, String colour) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}

	
}
