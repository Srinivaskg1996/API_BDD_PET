package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class SpecBuilder {
	
	public static RequestSpecification getsepc(String HTTPmethod) {
	
		if(HTTPmethod.equalsIgnoreCase("post")) {
	RequestSpecification spec=new RequestSpecBuilder()
			.setBaseUri(BaseURL.getBaseUrl())
			.setContentType("application/json")
			.addHeader("accept", "application/json")
			.build();
	
	return spec;
		}
		else if(HTTPmethod.equalsIgnoreCase("get")){
			RequestSpecification spec=new RequestSpecBuilder()
					.setBaseUri(BaseURL.getBaseUrl())
					.addHeader("accept", "application/json")
					.build();
			
			return spec;
				}
		else {
			 throw new IllegalArgumentException("No spec available for the given HTTP method:" + HTTPmethod);
		}
		
	}
}
