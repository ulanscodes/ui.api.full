package beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyResponse {
	
	private String address;
	private String age;
	private String name;
	private String first_name;
	private String last_name;
	private String author;
	private String location;
	private List<Book> books;
	

}
