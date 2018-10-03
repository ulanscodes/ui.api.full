package beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Book {
	private String title;
	private String first_name;
	private String last_name;
	private String author;
	private String location;

	

}
