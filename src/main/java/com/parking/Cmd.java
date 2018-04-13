package com.parking;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;



public class Cmd {

	public Map<String, Method> cmdMap;

    public Cmd() {
    	cmdMap = new HashMap<String, Method>();
        try {
            populateCommandsHashMap();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private void populateCommandsHashMap() throws NoSuchMethodException {
    	cmdMap.put("create_parking_lot", ParkingLotUtility.class.getMethod("createParkingLot", String.class));
    	cmdMap.put("park", ParkingLotUtility.class.getMethod("doParking", String.class, String.class));
    	cmdMap.put("leave", ParkingLotUtility.class.getMethod("leave", String.class));
    	cmdMap.put("status", ParkingLotUtility.class.getMethod("status"));
    	cmdMap.put("registration_numbers_for_cars_with_colour", ParkingLotUtility.class.getMethod("getRegistrationNumbersFromcolorOfCar", String.class));
    	cmdMap.put("slot_numbers_for_cars_with_colour", ParkingLotUtility.class.getMethod("getSlotNumbersFromcolorOfCar", String.class));
    	cmdMap.put("slot_number_for_registration_number", ParkingLotUtility.class.getMethod("getSlotNumberFromregistrationNumbers", String.class));
    }
}
