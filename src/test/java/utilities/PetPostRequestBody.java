package utilities;

import java.util.Arrays;
import java.util.List;

import pojo.Catagory;
import pojo.PetPostRequest;
import pojo.Tags;

public class PetPostRequestBody {
	
	public static PetPostRequest requestData() {
	
	PetPostRequest rd= new PetPostRequest();
	rd.setId(22334455);
	rd.setName("Automation");
	
	Catagory cat= new Catagory();
	cat.setId(1122);
	cat.setName("Test");
	
	rd.setCategory(cat);
	
	List<String> url= Arrays.asList("uuul.com","www.google.com","www.tel.com");
	rd.setPhotoUrls(url);
	
	Tags tag1= new Tags();
	tag1.setId(456);
	tag1.setName("SKG1");
	
	Tags tag2= new Tags();
	tag2.setId(456);
	tag2.setName("SKG1");
	
	List<Tags> tags=Arrays.asList(tag1,tag2);
	rd.setTags(tags);
	
	rd.setStatus("available");
	
	return rd;
	
	}
	

}
