import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test(dataProvider="BookData")
	public void addBook(String isbn, String aisle)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		
		
		////POST //////////////////////
		
		String addingBook = given().header("Content-Type","application/json")
		.body(Pyload.AddBook(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = new JsonPath(addingBook);
	 	 	String id = js.get("ID");
	 	 	
	 	 	System.out.println(id);
				
	}
	
	@DataProvider(name="BookData")
	public Object[][] dataSet()
	{
		return  new Object[][] {{"asd", "qwe"}, {"zxc", "rty"}, {"fgh","hjk"}};
	}
	
}
