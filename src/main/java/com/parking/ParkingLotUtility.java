package com.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotUtility {

	int size=0;
	ArrayList<Integer> listOfAvailableSlots;
	Map<String, Car> slotAndCarMap;
	Map<String, String> RegNumAndSlotMap;
	Map<String, ArrayList<String>> colorOfCarandListofregistrationNumbersMap;

	public void createParkingLot(String parkinglotcount) {
		// TODO Auto-generated method stub
		this.size=Integer.parseInt(parkinglotcount);
		this.listOfAvailableSlots = new ArrayList<Integer>(){} ;
        for (int i=1; i<= this.size; i++) {
        	listOfAvailableSlots.add(i);
        }
        this.slotAndCarMap = new HashMap<String, Car>();
        this.RegNumAndSlotMap = new HashMap<String, String>();
        this.colorOfCarandListofregistrationNumbersMap = new HashMap<String, ArrayList<String>>();
		System.out.println("Created parking lot with " + parkinglotcount + " slots");

	}
	public void doParking(String registrationNumbers, String colorOfCar) {
		// TODO Auto-generated method stub
		
		System.out.println("Created parking lot with " + registrationNumbers + " :"+colorOfCar);

	}

}
