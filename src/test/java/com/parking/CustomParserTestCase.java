package com.parking;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomParserTestCase {


	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void parseTextInput() throws Exception {
		CustomParser customParser = new CustomParser();

		customParser.parseTextInput("dummy");
		assertEquals("Invalidinput", outContent.toString().trim().replace(" ", ""));
		customParser.parseTextInput("status");
		assertEquals("Invalidinput\nSorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
	}

}
