package com.itparis.b3.associations.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.itparis.b3.associations.common.Utilities;

public class CommonTest {

	@Test
	public void test() {
		assertEquals("24-12-2000", Utilities.ConvertDBDateToFRDate("2000-12-24", '-'));
		
		assertEquals("2000-12-24", Utilities.ConvertFRDateToDBDate("24/12/2000", '/'));
		
		assertEquals("test", Utilities.decodeStringFrom64Base(Utilities.encodeStringTo64Base("test")));
	}

}
