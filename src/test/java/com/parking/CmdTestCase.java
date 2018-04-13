package com.parking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CmdTestCase {

	 Cmd commands = new Cmd();
	    @Test
	    public void checkCommandInList() throws Exception {
	        assertFalse(commands.cmdMap.isEmpty());
	        assertTrue(commands.cmdMap.containsKey("create_parking_lot"));
	    }
}
