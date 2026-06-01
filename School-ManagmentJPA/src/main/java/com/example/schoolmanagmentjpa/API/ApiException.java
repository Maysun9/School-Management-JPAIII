package com.example.schoolmanagmentjpa.API;

public class ApiException extends  RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}