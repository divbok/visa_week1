package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

public class BookingClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.visa");
		ctx.refresh();
		BookingService service =ctx.getBean("bookingService",BookingService.class);
		
		/*
		 * User u1 = new User(); u1.setEmail("divbok"); u1.setPassword("1234");
		 * u1.setName("Div"); u1.setEnabled(true);
		 */
		User u = service.getUser("divbok","122");
		Hotel h =service.findHotelById(1);
		//System.out.println(h);
	
		/*
		 * Booking b= new Booking(h,u); long bid=service.createBooking(b);
		 * System.out.println(bid);
		 */ 	
		List<Hotel> hilton= service.findHotels("Hilton");
		for (Hotel ho : hilton) {
			System.out.println(ho);
		}
		
	}

}
