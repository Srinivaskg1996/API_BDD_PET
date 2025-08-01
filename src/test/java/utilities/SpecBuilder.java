package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class SpecBuilder {



	public static RequestSpecification getsepc(String HTTPmethod)  {


		PrintStream log;
		try {
			log = new PrintStream(new FileOutputStream("logging.txt", true)); 
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Could not create log file", e);
		}

		RequestSpecBuilder builder=new RequestSpecBuilder()
				.setBaseUri(BaseURL.getBaseUrl())
				.addHeader("accept", "application/json")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log));


		switch(HTTPmethod.toLowerCase()) {
		case "post":
			builder
			.setContentType("application/json");			
			break;

		case "get":
			break;

		case "put":	
			builder
			.addHeader("accept", "application/json")
			.setContentType("application/x-www-form-urlencoded")
			.addFormParam("name", "doggy");
			break;

		case "delete":
			break;

		case "post image":
			builder
			.setContentType("multipart/form-data")
			.addMultiPart("additionalMetadata","234")
			.addMultiPart("file",new File("C:\\Users\\lenovo\\Downloads\\shoe.jpg"));
			break;

		default:throw new IllegalArgumentException("No spec available for the given HTTP method:" + HTTPmethod);

		}

		return builder.build();
	}
}
