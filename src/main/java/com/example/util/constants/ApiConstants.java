package com.example.util.constants;

public class ApiConstants {
    private ApiConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // ✅ General API Messages
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String ERROR = "error";
    public static final String NOT_FOUND = "Resource not found";
    public static final String INVALID_REQUEST = "Invalid request";
    public static final String BAD_REQUEST = "Bad request";
    public static final String DATA_NOT_FOUND = "No data available";
    public static final String OPERATION_SUCCESS = "Operation completed successfully";
    public static final String OPERATION_FAILED = "Operation failed";

    // ✅ Authentication & Authorization Messages
    public static final String AUTH_SUCCESS = "Authentication successful";
    public static final String AUTH_FAILED = "Authentication failed";
    public static final String UNAUTHORIZED = "Unauthorized access";
    public static final String FORBIDDEN = "You do not have permission to perform this action";
    public static final String TOKEN_EXPIRED = "Session expired, please log in again";
    public static final String TOKEN_INVALID = "Invalid authentication token";
    public static final String ACCOUNT_LOCKED = "Your account is locked. Please contact support";

    // ✅ Validation Messages
    public static final String VALIDATION_FAILED = "Validation failed";
    public static final String MISSING_REQUIRED_FIELDS = "Missing required fields";
    public static final String INVALID_INPUT = "Invalid input provided";
    public static final String EMAIL_ALREADY_EXISTS = "Email already exists";
    public static final String USERNAME_ALREADY_EXISTS = "Username already exists";
    public static final String PASSWORD_TOO_WEAK = "Password does not meet security requirements";
    public static final String PASSWORD_MISMATCH = "Passwords do not match";

    // ✅ System & Server Errors
    public static final String INTERNAL_SERVER_ERROR = "Internal server error. Please try again later";
    public static final String SERVICE_UNAVAILABLE = "Service is currently unavailable";
    public static final String DATABASE_ERROR = "Database error occurred";
    public static final String TIMEOUT_ERROR = "Request timed out, please try again";
    public static final String CONFLICT_ERROR = "Data conflict detected";

    // ✅ File Upload & Processing
    public static final String FILE_UPLOAD_SUCCESS = "File uploaded successfully";
    public static final String FILE_UPLOAD_FAILED = "File upload failed";
    public static final String FILE_SIZE_EXCEEDED = "File size exceeds the allowed limit";
    public static final String UNSUPPORTED_FILE_TYPE = "Unsupported file format";

    public static final class user_status {
        public static final String ACTIVE = "ACTIVE";
        public static final String INACTIVE = "INACTIVE";
    }
}
