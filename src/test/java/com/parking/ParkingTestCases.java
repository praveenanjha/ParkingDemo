package com.parking;

import static org.junit.Assert.*;

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
	
	

}
