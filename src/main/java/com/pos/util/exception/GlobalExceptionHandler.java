package com.pos.util.exception;

import com.pos.dto.model.response.ApiResponse;
import io.quarkus.logging.Log;
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
        }else if (exception instanceof NotFoundException){
            status = Response.Status.NOT_FOUND;
            response = new ApiResponse<>(status.getStatusCode(), exception.getMessage(), null);
        }else {
            status = Response.Status.INTERNAL_SERVER_ERROR;
            Log.error(exception.getMessage());
            response = new ApiResponse<>(status.getStatusCode(), "Internal server error", null);
        }

        return Response.status(status)
                .type(MediaType.APPLICATION_JSON)
                .entity(response)
                .build();
    }
}
