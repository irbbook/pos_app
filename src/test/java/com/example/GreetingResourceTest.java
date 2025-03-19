package com.example;

import com.example.dto.model.response.ApiResponse;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class GreetingResourceTest {

    private final GreetingResource greetingResource = new GreetingResource();

    @Test
    void hello() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

    @Test
    void getHello() {

        // Call the API method
        Response response = greetingResource.getHello();

        // Assertions
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        // Deserialize response entity
        ApiResponse<?> apiResponse = (ApiResponse<?>) response.getEntity();
        assertNotNull(apiResponse);
        assertEquals("success", apiResponse.status());
        assertEquals("API call successful", apiResponse.message());
        assertNull(apiResponse.data()); // Expecting null data
    }
}