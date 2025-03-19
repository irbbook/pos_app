package com.example.util.exception;

import com.example.dto.model.response.ApiResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        ApiResponse<String> response;
        Response.Status status;

        if (exception instanceof DuplicateDataException) {
            status = Response.Status.CONFLICT;
            response = new ApiResponse<>(status.getStatusCode(), exception.getMessage(), null);
        } else {
            status = Response.Status.INTERNAL_SERVER_ERROR;
            response = new ApiResponse<>(status.getStatusCode(), "Internal server error", null);
        }

        return Response.status(status)
                .type(MediaType.APPLICATION_JSON)
                .entity(response)
                .build();
    }
}
