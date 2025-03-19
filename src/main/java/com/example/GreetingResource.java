package com.example;

import com.example.dto.model.response.ApiResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        return "Hello RESTEasy";
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHello() {
        ApiResponse<String> response = new ApiResponse<>(
                "success",
                "API call successful",
                null
        );

        return Response.status(Response.Status.OK)
                .entity(response)
                .build();
    }

}
