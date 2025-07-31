package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.PetPostRequest;
import utilities.HttpUrl;
import utilities.PetPostRequestBody;
import utilities.SpecBuilder;

import static io.restassured.RestAssured.*;

import static org.junit.Assert.*;




public class StepDefination {
	RequestSpecification request;
	Response res;
	PetPostRequest petRequestData;
	static int id;
	RequestSpecification req_get;
	//Response res_get;

	//post data API

	@Given("the pet store API is available")
	public void the_pet_store_api_is_available() {
		petRequestData = PetPostRequestBody.requestData();
		request=given()
				.spec(SpecBuilder
				.getsepc("post"))
				.body(petRequestData); 
	}

	@When("I send a {string} request to add the pet")
	public void i_send_a_request_to_add_the_pet(String methodname) {
		res=request
				.when().post(HttpUrl.POST.geturl())
				.then()
				.extract()
				.response();
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(int ints) {
		int act=res.getStatusCode();
		assertEquals(act, ints);
		System.out.println("Status code is correct "+act);

	}

	@And("the response should contain the pet details")
	public void the_response_should_contains_the_pet_details() {
		res.then().log().body();

		PetPostRequest response=res.as(PetPostRequest.class);
		int expectedId = petRequestData.getId();
		int actualId=response.getId();
		this.id=actualId;

		String url=response.getPhotoUrls().get(2);
		System.out.println(url);
		int tag=response.getTags().getFirst().getId();
		System.out.println(tag);
		assertEquals(actualId,expectedId);
		System.out.println("value of the id is"+actualId);
	}

	

	//preparing get data API

	@Given("set request for {string} request")
	public void set_request_for_request(String HttpMethod) {
		req_get=given()
				.spec(SpecBuilder
				.getsepc(HttpMethod));
	}

	@When("I send a get request to get the pet data")
	public void i_send_a_request_to_get_the_pet_data() {
		res=req_get
				.when()
				.get(HttpUrl.GET.geturl(id))
				.then()
				.extract()
				.response();
		res.then().log().all();
		
		System.out.println(id);
	}

	@Then("the response status code should contain {int}")
	public void the_response_status_code_should_contain(int expectedCode) {
		assertEquals(res.getStatusCode(),expectedCode);
		System.out.println("Status code is matching"+res.getStatusCode());
	}

	@Then("pet status should be {string}")
	public void pet_status_should_be(String Expectedstatus) {
		res.then().log().body();
		PetPostRequest gr=res.as(PetPostRequest.class);
		String actStatus=gr.getStatus();
		assertEquals(actStatus,Expectedstatus);
		System.out.println(actStatus);
	}


}
