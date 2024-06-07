package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class AccessToken {
    private static String accessToken;

    // Method to obtain access token
    @Test
    public static void obtainAccessToken() {
        String tokenEndpoint = "https://aisurety-dev.au.auth0.com/oauth/token";

        String clientId = "8YAgi4oHbVebnlEmqs4RoDm7Hky6SNiI";
        String clientSecret = "GGfrAMDCklA8BhEUGkEn2Spwat4KKT96bBcCRIpChd7h7HIeWwa4M8XbTk6qmf6y";
        String audience = "AISurety-GraileAPI";

        String requestBody = "{\n" +
                "\"grant_type\": \"client_credentials\",\n" +
                "\"client_id\": \"" + clientId + "\",\n" +
                "\"client_secret\": \"" + clientSecret + "\",\n" +
                "\"audience\": \"" + audience + "\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(tokenEndpoint);

        accessToken = response.jsonPath().getString("access_token"); // Assign to the class-level variable
        System.out.println("Access Token: " + accessToken);
    }

    // Method to retrieve the access token
    public static String getAccessToken() {
        if (accessToken == null) {
            obtainAccessToken(); // If access token is null, obtain a new one
        }
        return accessToken;
    }
}