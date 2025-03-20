package com.pos.util.exception;

public class DuplicateDataException extends RuntimeException {
    public DuplicateDataException(String message){
        super(message);
    }
}
