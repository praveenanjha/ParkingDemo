package com.parking;

import java.util.ArrayList;
import java.util.Collections;
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
		
		 if (this.size == 0) {
	            System.out.println("Parking lot is not created");
	        } else if (this.slotAndCarMap.size() == this.size) {
	            System.out.println("Sorry, parking lot is full");
	            System.out.println();
	        } else {
	            Collections.sort(listOfAvailableSlots);
	            String slot = listOfAvailableSlots.get(0).toString();
	            Car car = new Car(registrationNumbers, colorOfCar);
	            this.slotAndCarMap.put(slot, car);
	            this.RegNumAndSlotMap.put(registrationNumbers, slot);
	            if (this.colorOfCarandListofregistrationNumbersMap.containsKey(colorOfCar)) {
	                ArrayList<String> registrationNumbersList = this.colorOfCarandListofregistrationNumbersMap.get(colorOfCar);
	                this.colorOfCarandListofregistrationNumbersMap.remove(colorOfCar);
	                registrationNumbersList.add(registrationNumbers);
	                this.colorOfCarandListofregistrationNumbersMap.put(colorOfCar, registrationNumbersList);
	            } else {
	                ArrayList<String> registrationNumbersList = new ArrayList<String>();
	                registrationNumbersList.add(registrationNumbers);
	                this.colorOfCarandListofregistrationNumbersMap.put(colorOfCar, registrationNumbersList);
	            }
	            System.out.println("Allocated slot number: " + slot);
	            System.out.println();
	            listOfAvailableSlots.remove(0);
	        }
}

}
