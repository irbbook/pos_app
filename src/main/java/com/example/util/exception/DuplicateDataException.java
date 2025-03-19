package com.example.util.exception;

public class DuplicateDataException extends RuntimeException {
    public DuplicateDataException(String message){
        super(message);
    }
}
