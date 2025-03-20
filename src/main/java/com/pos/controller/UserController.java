package com.pos.controller;

import com.pos.adapter.entity.PosTblUserEntity;
import com.pos.dto.model.response.ApiResponse;
import com.pos.dto.request.UserRequest;
import com.pos.service.UserService;
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

    @PUT
    @Path("/{username}")
    public Response updateUser(@PathParam("username") String username , UserRequest request) {
        Log.info("===== START Update  User =====");

        ApiResponse<String> response = userService.updateUser(username, request);

        Log.info("===== END Update User =====");
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @DELETE
    public Response deleteUser(@QueryParam("username") String username) {
        Log.info("===== START Delete User =====");

        ApiResponse<String> response = userService.deleteUser(username);

        Log.info("===== END Delete User =====");
        return Response.status(Response.Status.OK).entity(response).build();
    }

}
