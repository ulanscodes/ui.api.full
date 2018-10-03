package utilities;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.MyRequest;
import beans.MyResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ServiceRunner {

	private static MyResponse resp;
	private static ObjectMapper mapper = new ObjectMapper();
	private static int statusCode;
	private static Response mr;

	public static void runGetRquest(String uri) {
		 mr = RestAssured.get(uri);
		statusCode = mr.statusCode();

		try {
			resp = mapper.readValue(mr.asString(), MyResponse.class);

		} catch (IOException e) {
			System.out.println("Json could not map MyResponse object");
		}

	}

	public static void runPostRequest(String uri, MyRequest body) {
		String json = "";
		statusCode = mr.statusCode();

		try {
			json = mapper.writeValueAsString(body);

		} catch (JsonProcessingException e) {
			System.out.println("Cound not convert from POJO to Json");

		}

		 mr = RestAssured.given().contentType(ContentType.JSON).body(json).post(uri);

		try {
			resp = mapper.readValue(mr.asString(), MyResponse.class);

		} catch (IOException e) {
			System.out.println("Json could not map into Myresponse object");

		}
	}

	public static MyResponse getResponse() {
		return resp;
	}
	
	public static int getStatusCode() {
		return statusCode;
	}

}
