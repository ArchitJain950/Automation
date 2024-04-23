import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class BasicRestAssured {
	
	public static void main(String[] args)
{
	
		RestAssured.baseURI = "https://www.rahulshettyAcademy.com";
		
		/////// Post API
		
	        String response =  
				given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type","application/json")
				.body(BasicRestAssured.Postbody())
				.when().post("maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200)
		        .body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)")
		        .contentType("application/json").extract().response().asString();
	
	        	//// json parser
	        
	             JsonPath js = new JsonPath(response);
	             String placeId= js.getString("place_id");
	             System.out.println(placeId);
	             
	             ///////  Update API 
	             
	             String newaddr = "Deoli";
	             
	             given().log().all().queryParam("key", "qaclick123")
					.header("Content-Type","application/json")
					.body(BasicRestAssured.PutBody(placeId, newaddr))
					.when().put("maps/api/place/update/json")
					.then().log().all().assertThat().statusCode(200)
					.body("msg", equalTo("Address successfully updated"));
	             
	             //////Get API 
	             
	             given().log().all().queryParam("key", "qaclick123")
					.queryParam("place_id",placeId)
					.when().get("maps/api/place/get/json")
					.then().log().all().assertThat().statusCode(200)
					.body("address", equalTo(newaddr));
	             
	             
};
 

	
 public static String Postbody()
 {
	return "{\r\n"
			+ "\r\n"
			+ "\"location\": {\r\n"
			+ "\r\n"
			+ "\"lat\": -38.383494,\r\n"
			+ "\r\n"
			+ "\"lng\": 33.427362\r\n"
			+ "\r\n"
			+ "},\r\n"
			+ "\r\n"
			+ "\"accuracy\": 50,\r\n"
			+ "\r\n"
			+ "\"name\": \"Frontline house\",\r\n"
			+ "\r\n"
			+ "\"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "\r\n"
			+ "\"address\": \"29, side layout, cohen 09\",\r\n"
			+ "\r\n"
			+ "\"types\": [\r\n"
			+ "\r\n"
			+ "\"shoe park\",\r\n"
			+ "\r\n"
			+ "\"shop\"\r\n"
			+ "\r\n"
			+ "],\r\n"
			+ "\r\n"
			+ "\"website\": \"http://google.com\",\r\n"
			+ "\r\n"
			+ "\"language\": \"French-IN\"\r\n"
			+ "\r\n"
			+ "}";
 }
 
 
 public static String PutBody(String placeid, String addr)
 {
	return  "{\r\n"
			+ " \"place_id\": \""+ placeid +"\",\r\n"
			+ "  \"address\": \""+ addr +"\",\r\n"
			+ "  \"key\": \"qaclick123\"\r\n"
			+ "}";
 }

}

 
