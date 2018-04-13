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

	public void leave(String slotNo) {
        if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.slotAndCarMap.size() > 0) {
            Car carToLeave = this.slotAndCarMap.get(slotNo);
            if (carToLeave != null) {
                this.slotAndCarMap.remove(slotNo);
                this.RegNumAndSlotMap.remove(carToLeave.registrationNumbers);
                ArrayList<String> registrationNumbersList = this.colorOfCarandListofregistrationNumbersMap.get(carToLeave.colorOfCar);
                if (registrationNumbersList.contains(carToLeave.registrationNumbers)) {
                    registrationNumbersList.remove(carToLeave.registrationNumbers);
                }
                // Add the Lot No. back to available slot list.
                this.listOfAvailableSlots.add(Integer.parseInt(slotNo));
                System.out.println("Slot number " + slotNo + " is free");
                System.out.println();
            } else {
                System.out.println("Slot number " + slotNo + " is already empty");
                System.out.println();
            }
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
	public void status() {
        if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.slotAndCarMap.size() > 0) {
            // Print the current status.
            System.out.println("Slot No.\tRegistration No.\tcolorOfCar");
            Car car;
            for (int i = 1; i <= this.size; i++) {
                String key = Integer.toString(i);
                if (this.slotAndCarMap.containsKey(key)) {
                    car = this.slotAndCarMap.get(key);
                    System.out.println(i + "\t" + car.registrationNumbers + "\t" + car.colorOfCar);
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
	public void getRegistrationNumbersFromcolorOfCar(String colorOfCar) {
        if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.colorOfCarandListofregistrationNumbersMap.containsKey(colorOfCar)) {
            ArrayList<String> registrationNumbersList = this.colorOfCarandListofregistrationNumbersMap.get(colorOfCar);
            System.out.println();
            for (int i=0; i < registrationNumbersList.size(); i++) {
                if (!(i==registrationNumbersList.size() - 1)){
                    System.out.print(registrationNumbersList.get(i) + ",");
                } else {
                    System.out.print(registrationNumbersList.get(i));
                }
            }
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    public void getSlotNumbersFromcolorOfCar(String colorOfCar) {
        if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.colorOfCarandListofregistrationNumbersMap.containsKey(colorOfCar)) {
            ArrayList<String> registrationNumbersList = this.colorOfCarandListofregistrationNumbersMap.get(colorOfCar);
            ArrayList<Integer> slotList = new ArrayList<Integer>();
            System.out.println();
            for (int i=0; i < registrationNumbersList.size(); i++) {
                slotList.add(Integer.valueOf(this.RegNumAndSlotMap.get(registrationNumbersList.get(i))));
            }
            Collections.sort(slotList);
            for (int j=0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ",");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            System.out.println();
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    public void getSlotNumberFromregistrationNumbers(String registrationNumbers) {
        if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.RegNumAndSlotMap.containsKey(registrationNumbers)) {
            System.out.println(this.RegNumAndSlotMap.get(registrationNumbers));
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
}
