package com.visa.prj.entity;

public class Time {
	private int hours,min;
	
	public Time(int h,int m){
		this.hours = h;
		this.min = m;
	}
	
	public int getHours()
	{
		return this.hours;
	}
	
	public int getMin()
	{
		return this.min;
	}
	
	public Time addTime(Time t) {
		this.hours += t.hours;
		this.min += t.min ;
		if(this.min>=60)
		{
			this.hours +=1;
			this.min -= 60;
		}
		return this;
	}
	public static Time addTime(Time t1,Time t2) {
		Time t =new Time(0,0);
		t.hours = t1.hours + t2.hours;
		t.min = t1.min + t2.min ;
		if(t.min>=60)
		{
			t.hours +=1;
			t.min -= 60;
		}
		return t;
		
	}
		
	}
	

