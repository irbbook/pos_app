package com.example.controller;

import com.example.adapter.entity.PosTblUserEntity;
import com.example.dto.model.response.ApiResponse;
import com.example.dto.request.UserRequest;
import com.example.service.UserService;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/pos/v1/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    UserService userService;

    @POST
    public Response createUser(UserRequest request) {
        Log.info("===== START Create User =====");

        ApiResponse<String> response = userService.createUser(request);

        Log.info("===== END Create User =====");
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    public Response queryAllUser() {
        Log.info("===== START Query All User =====");

        ApiResponse<List<PosTblUserEntity>> response = userService.getAllUser();

        Log.info("===== END Query All User =====");
        return Response.status(Response.Status.OK).entity(response).build();
    }

}
