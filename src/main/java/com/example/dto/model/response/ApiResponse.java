package com.example.dto.model.response;

public record ApiResponse<T>(int status, String message, T data) {
}
