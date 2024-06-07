package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.payload.User;

// userendpoints.java created for performing Create, Read, Update and Delete requests to the respective api

public class UserEndPoints2 
{
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	static String accessToken = AccessToken.getAccessToken();
	//method created for getting url's from properties
	
	public static Response createUser(User payload)
	{
		String post_url = getURL().getString("post_url");
	  Response response = given()
		.header("Authorization", "Bearer " + accessToken)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
	  .when()
	     .post(post_url);
	// Converting response to JSON array
      JSONArray jsonArray = new JSONArray(response.asString());

      // List to store Facility IDs
      List<String> facilityIds = new ArrayList<>();

      // Iterating through the JSON array and storing Facility IDs
      for (int i = 0; i < jsonArray.length(); i++) {
          String facilityId = jsonArray.getJSONObject(i).getString("FacilityID");
          facilityIds.add(facilityId);
          System.out.println("The facility ID is: " + facilityId);
      }

   
	  return response;
	}

	@Test(priority=1)
    public static Response testFacilityJsonResponse()
    {
		String get_url = getURL().getString("get_url");
        //String accessToken = AccessTokenManager.getAccessToken(); // Retrieve access token
        Response res= given()
            .header("Authorization", "Bearer " + accessToken)
            .contentType(ContentType.JSON)
            .when()
            .get(get_url);

        System.out.println("Response Body: " + res.getBody().asString());
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		return res;
	
}
}
