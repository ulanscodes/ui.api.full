package tests;

import org.testng.annotations.Test;

import beans.Book;
import beans.MyRequest;
import utilities.ServiceRunner;

public class JsonTest {

	@Test
	public void utilTest() {
		ServiceRunner.runGetRquest("http://localhost:3000/profile");
		String location = ServiceRunner.getResponse().getAuthor();
		System.out.println(location);
		
	   for (Book book : ServiceRunner.getResponse().getBooks()) {
		System.out.println(book.getTitle());
	}
		
	}
	
//	@Test
	public void utilTestPost() {
		MyRequest mr = new MyRequest();
		
		mr.setAge(25);
		mr.setLocation("Chicago, Il");
		
		ServiceRunner.runPostRequest("http://localhost:3000/profile", mr);
		
		String location = ServiceRunner.getResponse().getLocation();
		System.out.println(location);
		
		
	}

	
}










