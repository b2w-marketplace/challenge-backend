package com.italomlaino.backendchallenge.exception;

public class InvalidDateRangeException extends RuntimeException {

    public static final String MESSAGE = "Invalid date range: before date must be greater than final date";

    public InvalidDateRangeException() {
        super(MESSAGE);
    }
}
