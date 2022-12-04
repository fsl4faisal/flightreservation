package com.flight.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorDetails {
    private final LocalDateTime timestamp;
    private final String description;
    private final String message;
}
