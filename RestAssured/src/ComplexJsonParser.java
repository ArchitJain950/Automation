import io.restassured.path.json.JsonPath;

public class ComplexJsonParser {

	public static void main( String[] args)
	{
		JsonPath js = new JsonPath(Pyload.CoursePrice());
		
		//Course size
		System.out.println(js.getInt("courses.size()"));
		
		
		String title = js.get("courses[2].title");
		System.out.println(title);
	}
	
}
