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
	
	

}
