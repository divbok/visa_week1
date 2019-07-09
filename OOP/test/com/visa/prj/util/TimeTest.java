package com.visa.prj.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visa.prj.entity.Time;

public class TimeTest {

	@Test
	public void testAddTimeTime() {
		Time t1 = new Time(4,30);
		Time t2 = new Time(3,45);
		t1.addTime(t2);
		assertEquals(8,t1.getHours());
		assertEquals(15,t1.getMin());
	}

	@Test
	public void testAddTimeTimeTime() {
		Time t1 = new Time(4,30);
		Time t2 = new Time(3,45);
		Time t3 = Time.addTime(t1,t2);
		assertEquals(8,t3.getHours());
		assertEquals(15,t3.getMin());
		
	}

}
