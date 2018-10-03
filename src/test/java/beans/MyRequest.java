package beans;

import lombok.Data;

@Data
public class MyRequest {
	private String first_name;
	private String last_name;
	private String author;
	private String location;
	private int age;

}
