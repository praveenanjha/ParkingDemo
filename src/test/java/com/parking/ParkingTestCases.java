package com.parking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParkingTestCases {

	ParkingLotUtility parkingLotUtility=new ParkingLotUtility();
    
	@Test
	public void testCreate_parking_lot() {
		
		parkingLotUtility.createParkingLot("6");
        assertEquals(6, parkingLotUtility.listOfAvailableSlots.size());
	}
	
	@Test
	public void testPark() {
		
		parkingLotUtility.createParkingLot("6");
		parkingLotUtility.doParking("park KA-01-HH-1234", "White");
        assertEquals(5, parkingLotUtility.listOfAvailableSlots.size());

	}
	
	@Test
	public void testLeave() {
		
		parkingLotUtility.createParkingLot("6");
		parkingLotUtility.doParking("KA-01-HH-1234", "White");
		parkingLotUtility.doParking("KA-01-HH-9999", "White");
		parkingLotUtility.leave("2");
        assertEquals(5, parkingLotUtility.listOfAvailableSlots.size());

	}
	@Test
	public void testStatus() {
		parkingLotUtility.status();
		parkingLotUtility.createParkingLot("6");
		parkingLotUtility.doParking("KA-01-HH-1234", "White");
		parkingLotUtility.doParking("KA-01-HH-9999", "White");
		parkingLotUtility.status();
	}
	
	 @Test
	    public void testRegNumsFromColor() throws Exception {
		 parkingLotUtility.getRegistrationNumbersFromcolorOfCar("White");
		 parkingLotUtility.createParkingLot("6");
		 parkingLotUtility.doParking("KA-01-HH-1234", "White");
		 parkingLotUtility.doParking("KA-01-HH-9999", "White");
		 parkingLotUtility.getRegistrationNumbersFromcolorOfCar("White");	       
		 parkingLotUtility.getRegistrationNumbersFromcolorOfCar("Red");
	       
	    }

	    @Test
	    public void testSlotNumbersFromColor() throws Exception {
	    	parkingLotUtility.getSlotNumbersFromcolorOfCar("White");
	    	parkingLotUtility.createParkingLot("6");
	    	parkingLotUtility.doParking("KA-01-HH-1234", "White");
	    	parkingLotUtility.doParking("KA-01-HH-9999", "White");
	        parkingLotUtility.getSlotNumbersFromcolorOfCar("White");	        
	        parkingLotUtility.getSlotNumbersFromcolorOfCar("Red");
	       
	    }

	    @Test
	    public void testSlotNumberFromRegNo() throws Exception {
	    	parkingLotUtility.getSlotNumberFromregistrationNumbers("KA-01-HH-1234");
	    	parkingLotUtility.createParkingLot("6");
	    	parkingLotUtility.doParking("KA-01-HH-1234", "White");
	    	parkingLotUtility.doParking("KA-01-HH-9999", "White");
	    	parkingLotUtility.getSlotNumberFromregistrationNumbers("KA-01-HH-1234");
	        
	    	parkingLotUtility.getSlotNumberFromregistrationNumbers("KA-01-HH-9999");
	        
	    	parkingLotUtility.leave("1");
	    	parkingLotUtility.getSlotNumberFromregistrationNumbers("KA-01-HH-1234");
	       	}

}
