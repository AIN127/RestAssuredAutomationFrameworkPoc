package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints2;
import api.payload.User;
//import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 
{
	User userPayLoad;
	
	@BeforeClass
	public void setUpData()
	{
		userPayLoad=new User();
		
		userPayLoad.setIncludeCart("true");
		userPayLoad.setIncludeExpiredData("true");
	}
	
	
	@Test(priority=1)
	 public void testPostUser()
	 {
		Response response=UserEndPoints2.createUser(userPayLoad);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	 }
	

	
	@Test(priority=2)
	 public void getFacilitySummary()
	 {
		Response res=UserEndPoints2.testFacilityJsonResponse();
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		
	 }
}
